package com.etiya.ecommercedemopair7.business.request.basketItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddBasketItemRequest {
    @Min(1)
    private int quantity;
    @Min(1)
    private int sellerProductId;
    @Min(1)
    private int basketId;
}
