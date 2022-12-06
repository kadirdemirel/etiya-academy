package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.basketItems.AddBasketItemRequest;
import com.etiya.ecommercedemopair7.business.response.basketItems.AddBasketItemResponse;

public interface IBasketItemService {
    AddBasketItemResponse add(AddBasketItemRequest addBasketItemRequest);
}
