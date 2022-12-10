package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IOrderService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.orders.AddOrderRequest;
import com.etiya.ecommercedemopair7.business.response.orders.GetAllOrderResponse;
import com.etiya.ecommercedemopair7.business.response.orders.GetOrderResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "orders")
public class OrdersController {

    private IOrderService orderService;

    @Autowired
    public OrdersController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AddOrderRequest addOrderRequest) {
        return new ResponseEntity<>(orderService.add(addOrderRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public DataResult<List<GetAllOrderResponse>> getAll() {
        return this.orderService.getAll();
    }

    @GetMapping("/get-by-id")
    public DataResult<GetOrderResponse> getById(int orderId) {
        return this.orderService.getById(orderId);
    }
}
