package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.baskets.AddBasketRequest;
import com.etiya.ecommercedemopair7.business.response.baskets.AddBasketResponse;
import com.etiya.ecommercedemopair7.business.response.baskets.GetAllBasketResponse;

import java.util.List;

public interface IBasketService {
    List<GetAllBasketResponse> getAll();

    AddBasketResponse add(AddBasketRequest addBasketRequest);
}
