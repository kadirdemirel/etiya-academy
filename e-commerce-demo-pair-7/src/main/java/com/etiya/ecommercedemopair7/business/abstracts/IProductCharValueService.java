package com.etiya.ecommercedemopair7.business.abstracts;


import com.etiya.ecommercedemopair7.business.request.productCharValues.AddProductCharValueRequest;
import com.etiya.ecommercedemopair7.business.response.productCharValues.AddProductCharValueResponse;

public interface IProductCharValueService {
    AddProductCharValueResponse add(AddProductCharValueRequest addProductCharValueRequest);
}
