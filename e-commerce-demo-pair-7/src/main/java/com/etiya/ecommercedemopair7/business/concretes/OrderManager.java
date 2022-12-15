package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.*;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.invoices.AddInvoiceRequest;
import com.etiya.ecommercedemopair7.business.request.orderItems.AddOrderItemRequest;
import com.etiya.ecommercedemopair7.business.request.orders.AddOrderRequest;
import com.etiya.ecommercedemopair7.business.response.orders.AddOrderResponse;
import com.etiya.ecommercedemopair7.business.response.orders.GetAllOrderResponse;
import com.etiya.ecommercedemopair7.business.response.orders.GetOrderResponse;
import com.etiya.ecommercedemopair7.core.utilities.exceptions.BusinessException;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.*;
import com.etiya.ecommercedemopair7.entities.dtos.OrderDto;
import com.etiya.ecommercedemopair7.repository.abstracts.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class OrderManager implements IOrderService {

    private IOrderRepository orderRepository;
    private IDeliveryOptionService deliveryOptionService;
    private IAddressService addressService;
    private IModelMapperService modelMapperService;

    private IInvoiceService invoiceService;
    private IOrderItemService orderItemService;
    private IMessageSourceService messageSourceService;

    @Autowired
    public OrderManager(IOrderRepository orderRepository, IDeliveryOptionService deliveryOptionService,
                        IAddressService addressService, IModelMapperService modelMapperService,
                        IInvoiceService invoiceService, IOrderItemService orderItemService,
                        IMessageSourceService messageSourceService) {
        this.orderRepository = orderRepository;
        this.deliveryOptionService = deliveryOptionService;
        this.addressService = addressService;
        this.modelMapperService = modelMapperService;
        this.invoiceService = invoiceService;
        this.orderItemService = orderItemService;
        this.messageSourceService = messageSourceService;
    }

    @Override
    public DataResult<List<GetAllOrderResponse>> getAll() {
        List<Order> orders = this.orderRepository.findAll();
        List<GetAllOrderResponse> response = orders.stream()
                .map(order -> this.modelMapperService.forResponse().map(order, GetAllOrderResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Order.ordersListed));
    }

    @Override
    public DataResult<GetOrderResponse> getById(int orderId) {
        Order order = existByOrderId(orderId);
        GetOrderResponse response = modelMapperService.forResponse().map(order, GetOrderResponse.class);
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Order.orderReceived));
    }

    @Override
    public DataResult<List<OrderDto>> getOrderDto() {
        //TODO:Dto in dto mapping
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> response = orders.stream().map(order -> modelMapperService.forResponse()
                .map(order, OrderDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Order.ordersListed));
    }

    @Override
    public Order getByOrderId(int orderId) {
        return existByOrderId(orderId);
    }


    @Transactional
    @Override
    public DataResult<AddOrderResponse> add(AddOrderRequest addOrderRequest) {
        //TODO:Sipariş iş kuralı
        //TODO:Sepete ürünlerin eklenip siparişin oluşturulması
        //TODO: Basket item oluştuğunda ödeme(payment) yapılmalı
        //TODO: Ödeme yapıldı ise sipariş oluşmalı
        //TODO: Sipariş oluştuysa sipariş itemları oluşmalı(PAYMENT)
        getDeliveryOption(addOrderRequest.getDeliveryOptionId());
        getOrderAddress(addOrderRequest.getOrderAddressId());
        getInvoiceAddress(addOrderRequest.getInvoiceAddressId());

        Order order = modelMapperService.forRequest().map(addOrderRequest, Order.class);
        order.setOrderDate(LocalDate.now());
        order.setOrderNumber(String.valueOf(randomNumberGenerater()));

        Order savedOrder = orderRepository.save(order);

        AddOrderResponse response = modelMapperService.forResponse().map(savedOrder, AddOrderResponse.class);

        addOrderItem(savedOrder);
        addInvoice(savedOrder);

        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Order.orderAdded));
    }

    private void addOrderItem(Order savedOrder) {
        AddOrderItemRequest addOrderItemRequest = new AddOrderItemRequest();
        addOrderItemRequest.setOrderId(savedOrder.getId());
        addOrderItemRequest.setCustomerId(savedOrder.getPayment().getCustomer().getId());
        orderItemService.add(addOrderItemRequest);
    }

    private void addInvoice(Order savedOrder) {
        Invoice invoice = new Invoice();
        invoice.setOrder(savedOrder);
        invoice.setCreatedDate(LocalDate.now());
        invoice.setNumber(String.valueOf(randomNumberGenerater()));

        AddInvoiceRequest request = modelMapperService.forRequest().map(invoice, AddInvoiceRequest.class);

        this.invoiceService.add(request);
    }

    private static int randomNumberGenerater() {
        Random random = new Random();
        int invoiceNumber = random.nextInt(10000) + 1;
        return invoiceNumber;
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
            throw new BusinessException(messageSourceService.getMessage(Messages.Order.orderNotFound));
        }
        return currentOrder;
    }
}
