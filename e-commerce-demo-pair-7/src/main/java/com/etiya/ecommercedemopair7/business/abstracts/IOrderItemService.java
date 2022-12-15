package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.orderItems.AddOrderItemRequest;
import com.etiya.ecommercedemopair7.business.response.orderItems.AddOrderItemResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.Result;
import com.etiya.ecommercedemopair7.entities.concretes.BasketItem;
import com.etiya.ecommercedemopair7.entities.dtos.OrderItemDto;

import java.util.List;

public interface IOrderItemService {

    DataResult<List<OrderItemDto>> getOrderItemDto();

    Result add(AddOrderItemRequest addOrderItemRequest);
}
