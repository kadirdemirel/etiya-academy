package com.etiya.ecommercedemopair7.business.request.basketItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddBasketItemRequest {
    private int quantity;
    private double itemTotalPrice;
}
