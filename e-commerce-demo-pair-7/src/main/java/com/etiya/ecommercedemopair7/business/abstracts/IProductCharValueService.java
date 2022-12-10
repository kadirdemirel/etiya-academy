package com.etiya.ecommercedemopair7.business.abstracts;


import com.etiya.ecommercedemopair7.business.request.productCharValues.AddProductCharValueRequest;
import com.etiya.ecommercedemopair7.business.response.productCharValues.AddProductCharValueResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;

public interface IProductCharValueService {
    DataResult<AddProductCharValueResponse> add(AddProductCharValueRequest addProductCharValueRequest);
}
