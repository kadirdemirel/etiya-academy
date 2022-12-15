package com.etiya.ecommercedemopair7.business.request.baskets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBasketRequest {
    @Min(1)
    private int id;
    @Min(1)
    private int customerId;
}
