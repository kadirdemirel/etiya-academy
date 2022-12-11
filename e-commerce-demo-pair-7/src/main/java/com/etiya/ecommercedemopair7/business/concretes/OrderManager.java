package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IAddressService;
import com.etiya.ecommercedemopair7.business.abstracts.IDeliveryOptionService;
import com.etiya.ecommercedemopair7.business.abstracts.IOrderService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.orders.AddOrderRequest;
import com.etiya.ecommercedemopair7.business.response.orders.AddOrderResponse;
import com.etiya.ecommercedemopair7.business.response.orders.GetAllOrderResponse;
import com.etiya.ecommercedemopair7.business.response.orders.GetOrderResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Address;
import com.etiya.ecommercedemopair7.entities.concretes.DeliveryOption;
import com.etiya.ecommercedemopair7.entities.concretes.Order;
import com.etiya.ecommercedemopair7.entities.dtos.OrderDto;
import com.etiya.ecommercedemopair7.repository.abstracts.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public DataResult<List<GetAllOrderResponse>> getAll() {
        List<Order> orders = this.orderRepository.findAll();
        List<GetAllOrderResponse> response = orders.stream()
                .map(order -> this.modelMapperService.forResponse().map(order, GetAllOrderResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(response, Messages.Order.ordersListed);
    }

    @Override
    public DataResult<GetOrderResponse> getById(int orderId) {
        Order order = existByOrderId(orderId);
        GetOrderResponse response = modelMapperService.forResponse().map(order, GetOrderResponse.class);
        return new SuccessDataResult<>(response, Messages.Order.orderReceived);
    }

    @Override
    public DataResult<List<OrderDto>> getOrderDto() {
        //TODO:Dto in dto mapping
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> response = orders.stream().map(order -> modelMapperService.forResponse().map(order, OrderDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response, Messages.Order.ordersListed);
    }

    @Override
    public Order getByOrderId(int orderId) {
        return existByOrderId(orderId);
    }


    @Override
    public DataResult<AddOrderResponse> add(AddOrderRequest addOrderRequest) {
        getDeliveryOption(addOrderRequest.getDeliveryOptionId());
        getOrderAddress(addOrderRequest.getOrderAddressId());
        getInvoiceAddress(addOrderRequest.getInvoiceAddressId());
        Order order = modelMapperService.forRequest().map(addOrderRequest, Order.class);
        Order savedOrder = orderRepository.save(order);

        AddOrderResponse response = modelMapperService.forResponse().map(savedOrder, AddOrderResponse.class);
        return new SuccessDataResult<>(response, Messages.Order.orderAdded);

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

    private Order existByOrderId(int id) {
        Order currentOrder;
        try {
            currentOrder = this.orderRepository.findById(id).get();
        } catch (Exception ex) {
            throw new RuntimeException(Messages.Order.orderNotFound);
        }
        return currentOrder;
    }
}
