package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IPaymentTypeService;
import com.etiya.ecommercedemopair7.business.request.paymentTypes.AddPaymentTypeRequest;
import com.etiya.ecommercedemopair7.business.response.paymentTypes.AddPaymentTypeResponse;
import com.etiya.ecommercedemopair7.entities.concretes.PaymentType;
import com.etiya.ecommercedemopair7.repository.abstracts.IPaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentTypeManager implements IPaymentTypeService {
    private IPaymentTypeRepository paymentTypeRepository;

    @Autowired
    public PaymentTypeManager(IPaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    @Override
    public AddPaymentTypeResponse add(AddPaymentTypeRequest addPaymentTypeRequest) {
        PaymentType paymentType = new PaymentType();
        paymentType.setName(addPaymentTypeRequest.getName());
        PaymentType savedPaymentType = paymentTypeRepository.save(paymentType);
        AddPaymentTypeResponse response = new AddPaymentTypeResponse(savedPaymentType.getId(), savedPaymentType.getName());
        return response;
    }

}
