package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.paymentTypes.AddPaymentTypeRequest;
import com.etiya.ecommercedemopair7.business.response.paymentTypes.AddPaymentTypeResponse;
import com.etiya.ecommercedemopair7.business.response.paymentTypes.GetAllPaymentTypeResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;

import java.util.List;

public interface IPaymentTypeService {
    DataResult<AddPaymentTypeResponse> add(AddPaymentTypeRequest addPaymentTypeRequest);
    DataResult<List<GetAllPaymentTypeResponse>> getAll();
}
