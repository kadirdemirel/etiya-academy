package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IOrderService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.orders.AddOrderRequest;
import com.etiya.ecommercedemopair7.business.response.orders.AddOrderResponse;
import com.etiya.ecommercedemopair7.business.response.orders.GetAllOrderResponse;
import com.etiya.ecommercedemopair7.business.response.orders.GetOrderResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.dtos.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<DataResult<AddOrderResponse>> add(@RequestBody @Valid AddOrderRequest addOrderRequest) {
        return new ResponseEntity<>(orderService.add(addOrderRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<DataResult<List<GetAllOrderResponse>>> getAll() {
        return ResponseEntity.ok(this.orderService.getAll());
    }

    @GetMapping("/get-all-dto")
    public ResponseEntity<DataResult<List<OrderDto>>> getOrderDto() {
        return ResponseEntity.ok(this.orderService.getOrderDto());
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<DataResult<GetOrderResponse>> getById(int orderId) {
        return ResponseEntity.ok(this.orderService.getById(orderId));
    }
}
