package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.basketItems.AddBasketItemRequest;
import com.etiya.ecommercedemopair7.business.response.basketItems.AddBasketItemResponse;
import com.etiya.ecommercedemopair7.business.response.basketItems.GetAllBasketItemResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;

import java.util.List;

public interface IBasketItemService {
    DataResult<AddBasketItemResponse> add(AddBasketItemRequest addBasketItemRequest);

    DataResult<List<GetAllBasketItemResponse>> getAll();
}
