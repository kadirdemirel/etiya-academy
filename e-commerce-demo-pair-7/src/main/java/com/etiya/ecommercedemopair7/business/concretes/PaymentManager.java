package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.*;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.AddPaymentRequest;
import com.etiya.ecommercedemopair7.business.request.orders.AddOrderRequest;
import com.etiya.ecommercedemopair7.business.response.payments.AddPaymentResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.*;
import com.etiya.ecommercedemopair7.repository.abstracts.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class PaymentManager implements IPaymentService {
    private IPaymentRepository paymentRepository;
    private IModelMapperService modelMapperService;
    private IMessageSourceService messageSourceService;
    private IDeliveryOptionService deliveryOptionService;
    private IAddressService addressService;
    private IPaymentTypeService paymentTypeService;
    private IBasketService basketService;
    private IOrderService orderService;

    @Autowired
    PaymentManager(IPaymentRepository paymentRepository, IModelMapperService modelMapperService,
                   IMessageSourceService messageSourceService, IDeliveryOptionService deliveryOptionService,
                   IAddressService addressService, IPaymentTypeService paymentTypeService, IBasketService basketService, IOrderService orderService) {

        this.paymentRepository = paymentRepository;
        this.modelMapperService = modelMapperService;
        this.messageSourceService = messageSourceService;
        this.deliveryOptionService = deliveryOptionService;
        this.addressService = addressService;
        this.paymentTypeService = paymentTypeService;
        this.basketService = basketService;
        this.orderService = orderService;
    }

    @Transactional
    @Override
    public DataResult<AddPaymentResponse> add(AddPaymentRequest addPaymentRequest) {
        //TODO:Ödeme yapıldıysa ekleme işlemi gerçeşmeli.
        deliveryOptionService.getByDeliveryOptionId(addPaymentRequest.getDeliveryOptionId());
        addressService.getByUserId(addPaymentRequest.getInvoiceAddressId());
        addressService.getByUserId(addPaymentRequest.getOrderAddressId());
        paymentTypeService.getByPaymentTypeId(addPaymentRequest.getPaymentTypeId());

        Basket basket = basketService.getByCustomerId(addPaymentRequest.getCustomerId());

        Payment payment = modelMapperService.forRequest().map(addPaymentRequest, Payment.class);
        payment.setTotalPrice(basket.getTotalPrice());

        Payment savedPayment = paymentRepository.save(payment);
        AddPaymentResponse response = modelMapperService.forResponse().map(savedPayment, AddPaymentResponse.class);
        orderService.add(addOrderRequest(addPaymentRequest, savedPayment));

        return new SuccessDataResult<>(response,messageSourceService.getMessage(Messages.Payment.paymentAdded));
    }

    private AddOrderRequest addOrderRequest(AddPaymentRequest addPaymentRequest, Payment savedPayment) {
        AddOrderRequest addOrderRequest = new AddOrderRequest();
        addOrderRequest.setOrderAddressId(addPaymentRequest.getOrderAddressId());
        addOrderRequest.setInvoiceAddressId(addPaymentRequest.getInvoiceAddressId());
        addOrderRequest.setDeliveryOptionId(addPaymentRequest.getDeliveryOptionId());
        addOrderRequest.setTotalPrice(savedPayment.getTotalPrice());
        addOrderRequest.setPaymentId(savedPayment.getId());
        return addOrderRequest;
    }


}
