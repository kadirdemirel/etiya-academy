package com.etiya.ecommercedemopair7.business.response.paymentTypes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentTypeResponse {
    private int id;
    private String name;
}
