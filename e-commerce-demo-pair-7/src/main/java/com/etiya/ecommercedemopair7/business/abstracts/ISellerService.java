package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.sellers.AddSellerRequest;
import com.etiya.ecommercedemopair7.business.response.sellers.AddSellerResponse;

public interface ISellerService {
    AddSellerResponse add(AddSellerRequest addSellerRequest);
}
