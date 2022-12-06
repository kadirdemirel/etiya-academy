package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.productChars.AddProductCharRequest;

import com.etiya.ecommercedemopair7.business.response.productChars.AddProductCharResponse;
import com.etiya.ecommercedemopair7.entities.concretes.ProductChar;


public interface IProductCharService {
    ProductChar getById(int productCharId);
    AddProductCharResponse add(AddProductCharRequest addProductCharRequest);
}
