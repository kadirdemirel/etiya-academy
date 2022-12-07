package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IAddressService;
import com.etiya.ecommercedemopair7.business.abstracts.IDeliveryOptionService;
import com.etiya.ecommercedemopair7.business.abstracts.IOrderService;
import com.etiya.ecommercedemopair7.business.request.orders.AddOrderRequest;
import com.etiya.ecommercedemopair7.business.response.orders.AddOrderResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.Address;
import com.etiya.ecommercedemopair7.entities.concretes.DeliveryOption;
import com.etiya.ecommercedemopair7.entities.concretes.Order;
import com.etiya.ecommercedemopair7.repository.abstracts.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManager implements IOrderService {

    private IOrderRepository orderRepository;
    private IDeliveryOptionService deliveryOptionService;
    private IAddressService addressService;
    private IModelMapperService modelMapperService;

    @Autowired
    public OrderManager(IOrderRepository orderRepository, IDeliveryOptionService deliveryOptionService, IAddressService addressService, IModelMapperService modelMapperService) {
        this.orderRepository = orderRepository;
        this.deliveryOptionService = deliveryOptionService;
        this.addressService = addressService;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public AddOrderResponse add(AddOrderRequest addOrderRequest) {
        getDeliveryOption(addOrderRequest.getDeliveryOptionId());
        getOrderAddress(addOrderRequest.getOrderAddressId());
        getInvoiceAddress(addOrderRequest.getInvoiceAddressId());
        Order order = modelMapperService.forRequest().map(addOrderRequest, Order.class);
        Order savedOrder = orderRepository.save(order);

        AddOrderResponse response = modelMapperService.forResponse().map(savedOrder, AddOrderResponse.class);
        return response;

    }

    private Address getInvoiceAddress(int invoiceAddressId) {
        Address invoiceAddress = addressService.getByAddressId(invoiceAddressId);
        return invoiceAddress;
    }

    private Address getOrderAddress(int orderAddressId) {
        Address orderAddress = addressService.getByAddressId(orderAddressId);
        return orderAddress;
    }

    private DeliveryOption getDeliveryOption(int deliveryOptionId) {
        DeliveryOption deliveryOption = deliveryOptionService.getByDeliveryOptionId(deliveryOptionId);
        return deliveryOption;
    }
}
