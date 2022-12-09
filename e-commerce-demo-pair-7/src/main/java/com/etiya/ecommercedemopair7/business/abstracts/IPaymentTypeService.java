package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.paymentTypes.AddPaymentTypeRequest;
import com.etiya.ecommercedemopair7.business.response.districts.GetAllDistrictResponse;
import com.etiya.ecommercedemopair7.business.response.paymentTypes.AddPaymentTypeResponse;
import com.etiya.ecommercedemopair7.business.response.paymentTypes.GetAllPaymentTypeResponse;

import java.util.List;

public interface IPaymentTypeService {
    AddPaymentTypeResponse add(AddPaymentTypeRequest addPaymentTypeRequest);
    List<GetAllPaymentTypeResponse> getAll();
}
