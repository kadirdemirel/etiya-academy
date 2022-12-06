package com.etiya.ecommercedemopair7.business.response.basketItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBasketItemResponse {
    private int id;
    private int basketId;
    private int productId;
    private int quantity;
    private double itemTotalPrice;
}
