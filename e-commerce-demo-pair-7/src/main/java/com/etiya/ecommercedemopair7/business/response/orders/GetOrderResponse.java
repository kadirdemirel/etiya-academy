package com.etiya.ecommercedemopair7.business.response.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {
    private int id;
    private String orderNumber;
    private double totalPrice;

}
