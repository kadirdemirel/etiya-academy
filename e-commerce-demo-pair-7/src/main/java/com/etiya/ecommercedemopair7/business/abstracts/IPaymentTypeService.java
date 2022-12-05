package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.paymentTypes.AddPaymentTypeRequest;
import com.etiya.ecommercedemopair7.business.response.paymentTypes.AddPaymentTypeResponse;

public interface IPaymentTypeService {
    AddPaymentTypeResponse add(AddPaymentTypeRequest addPaymentTypeRequest);
}
