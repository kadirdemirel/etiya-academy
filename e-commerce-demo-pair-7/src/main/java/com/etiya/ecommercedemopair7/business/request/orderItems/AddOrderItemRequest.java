package com.etiya.ecommercedemopair7.business.request.orderItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderItemRequest {
    @Min(1)
    private int quantity;
    @Min(1)
    private double itemTotalPrice;
    @Min(1)
    private int orderId;
    @Min(1)
    private int sellerProductId;
    @Min(1)
    private int customerId;
}
