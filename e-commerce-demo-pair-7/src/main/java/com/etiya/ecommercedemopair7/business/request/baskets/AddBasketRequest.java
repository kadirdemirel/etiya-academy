package com.etiya.ecommercedemopair7.business.request.baskets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBasketRequest {
    private double totalPrice;
    private double shippingPrice;
}
