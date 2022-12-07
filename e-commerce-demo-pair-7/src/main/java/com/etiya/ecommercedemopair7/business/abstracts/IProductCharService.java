package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.productChars.AddProductCharRequest;

import com.etiya.ecommercedemopair7.business.response.productChars.AddProductCharResponse;
import com.etiya.ecommercedemopair7.business.response.productChars.GetProductCharResponse;
import com.etiya.ecommercedemopair7.entities.concretes.ProductChar;


public interface IProductCharService {
    GetProductCharResponse getById(int productCharId);
    ProductChar getByProductCharId(int productCharId);
    AddProductCharResponse add(AddProductCharRequest addProductCharRequest);
}
