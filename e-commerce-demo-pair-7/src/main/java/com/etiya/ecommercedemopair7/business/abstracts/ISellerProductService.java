package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.sellerProducts.AddSellerProductRequest;
import com.etiya.ecommercedemopair7.business.request.sellers.AddSellerRequest;
import com.etiya.ecommercedemopair7.business.response.sellerProducts.AddSellerProductResponse;
import com.etiya.ecommercedemopair7.business.response.sellers.AddSellerResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;

public interface ISellerProductService {
    DataResult<AddSellerProductResponse> add(AddSellerProductRequest addSellerProductRequest);
}
