package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.basketItems.AddBasketItemRequest;
import com.etiya.ecommercedemopair7.business.response.addresses.GetAllAddressResponse;
import com.etiya.ecommercedemopair7.business.response.basketItems.AddBasketItemResponse;
import com.etiya.ecommercedemopair7.business.response.basketItems.GetAllBasketItemResponse;

import java.util.List;

public interface IBasketItemService {
    AddBasketItemResponse add(AddBasketItemRequest addBasketItemRequest);
    List<GetAllBasketItemResponse> getAll();
}
