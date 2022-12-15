package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.AddPaymentRequest;
import com.etiya.ecommercedemopair7.business.response.payments.AddPaymentResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;

public interface IPaymentService {
    DataResult<AddPaymentResponse> add(AddPaymentRequest addPaymentRequest);


}
