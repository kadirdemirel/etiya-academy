package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IPaymentTypeService;
import com.etiya.ecommercedemopair7.business.request.paymentTypes.AddPaymentTypeRequest;
import com.etiya.ecommercedemopair7.business.response.paymentTypes.AddPaymentTypeResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.PaymentType;
import com.etiya.ecommercedemopair7.repository.abstracts.IPaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentTypeManager implements IPaymentTypeService {
    private IPaymentTypeRepository paymentTypeRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public PaymentTypeManager(IPaymentTypeRepository paymentTypeRepository, IModelMapperService modelMapperService) {
        this.paymentTypeRepository = paymentTypeRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public AddPaymentTypeResponse add(AddPaymentTypeRequest addPaymentTypeRequest) {
        PaymentType paymentType = modelMapperService.forResponse().map(addPaymentTypeRequest, PaymentType.class);
        PaymentType savedPaymentType = paymentTypeRepository.save(paymentType);
        AddPaymentTypeResponse response = modelMapperService.forResponse().map(savedPaymentType, AddPaymentTypeResponse.class);
        return response;
    }

}
