package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.dtos.OrderItemDto;

import java.util.List;

public interface IOrderItemService {

    DataResult<List<OrderItemDto>> getOrderItemDto();
}
