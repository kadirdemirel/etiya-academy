package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.orders.AddOrderRequest;
import com.etiya.ecommercedemopair7.business.response.orders.AddOrderResponse;
import com.etiya.ecommercedemopair7.business.response.orders.GetAllOrderResponse;
import com.etiya.ecommercedemopair7.business.response.orders.GetOrderResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Order;
import com.etiya.ecommercedemopair7.entities.dtos.OrderDto;

import java.util.List;

public interface IOrderService {
    DataResult<AddOrderResponse> add(AddOrderRequest addOrderRequest);

    Order getByOrderId(int orderId);

    DataResult<List<GetAllOrderResponse>> getAll();

    DataResult<GetOrderResponse> getById(int orderId);

    DataResult<List<OrderDto>> getOrderDto();
}
