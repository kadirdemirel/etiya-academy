package com.etiya.ecommercedemopair7.business.response.orderItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderItemResponse {
    private int id;
    private int quantity;
    private double itemTotalPrice;
    private int orderId;
    private int sellerProductId;
}
