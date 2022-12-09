package com.etiya.ecommercedemopair7.business.response.basketItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBasketItemResponse {
    private int id;
    private double totalPrice;
    private double shippingPrice;
}
