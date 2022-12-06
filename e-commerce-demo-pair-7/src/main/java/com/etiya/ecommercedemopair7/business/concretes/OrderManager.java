package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IAddressService;
import com.etiya.ecommercedemopair7.business.abstracts.IDeliveryOptionService;
import com.etiya.ecommercedemopair7.business.abstracts.IOrderService;
import com.etiya.ecommercedemopair7.business.request.orders.AddOrderRequest;
import com.etiya.ecommercedemopair7.business.response.orders.AddOrderResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Address;
import com.etiya.ecommercedemopair7.entities.concretes.DeliveryOption;
import com.etiya.ecommercedemopair7.entities.concretes.Order;
import com.etiya.ecommercedemopair7.entities.concretes.Street;
import com.etiya.ecommercedemopair7.repository.abstracts.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManager implements IOrderService {

    private IOrderRepository orderRepository;
    private IDeliveryOptionService deliveryOptionService;
    private IAddressService addressService;

    @Autowired
    public OrderManager(IOrderRepository orderRepository, IDeliveryOptionService deliveryOptionService, IAddressService addressService) {
        this.orderRepository = orderRepository;
        this.deliveryOptionService = deliveryOptionService;
        this.addressService = addressService;
    }

    @Override
    public AddOrderResponse add(AddOrderRequest addOrderRequest) {
        Order order = new Order();
        order.setOrderNumber(addOrderRequest.getOrderNumber());
        order.setTotalPrice(addOrderRequest.getTotalPrice());
        order.setOrderDate(addOrderRequest.getOrderDate());

        DeliveryOption deliveryOption = getDeliveryOption(addOrderRequest.getDeliveryOptionId());
        order.setDeliveryOption(deliveryOption);

        Address orderAddress = getOrderAddress(addOrderRequest.getOrderAddressId());
        Address invoiceAddress = getInvoiceAddress(addOrderRequest.getInvoiceAddressId());

        order.setOrderAddress(orderAddress);
        order.setInvoiceAddress(invoiceAddress);

        Order savedOrder = orderRepository.save(order);

        return new AddOrderResponse(savedOrder.getId(), savedOrder.getOrderNumber(), savedOrder.getTotalPrice()
                , savedOrder.getOrderDate(), savedOrder.getDeliveryOption().getId(),
                savedOrder.getOrderAddress().getId(), savedOrder.getInvoiceAddress().getId());


    }
    private Address getInvoiceAddress(int invoiceAddressId) {
        Address invoiceAddress = addressService.getById(invoiceAddressId);
        return invoiceAddress;
    }
    private Address getOrderAddress(int orderAddressId) {
        Address orderAddress = addressService.getById(orderAddressId);
        return orderAddress;
    }

    private DeliveryOption getDeliveryOption(int deliveryOptionId) {
        DeliveryOption deliveryOption = deliveryOptionService.getById(deliveryOptionId);
        return deliveryOption;
    }
}
