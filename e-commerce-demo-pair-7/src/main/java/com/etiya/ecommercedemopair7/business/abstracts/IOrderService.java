package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.orders.AddOrderRequest;
import com.etiya.ecommercedemopair7.business.response.orders.AddOrderResponse;
import com.etiya.ecommercedemopair7.business.response.orders.GetAllOrderResponse;
import com.etiya.ecommercedemopair7.business.response.orders.GetOrderResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Order;

import java.util.List;

public interface IOrderService {
    AddOrderResponse add(AddOrderRequest addOrderRequest);
    Order getByOrderId(int orderId);
    List<GetAllOrderResponse> getAll();
    GetOrderResponse getById(int orderId);
}
