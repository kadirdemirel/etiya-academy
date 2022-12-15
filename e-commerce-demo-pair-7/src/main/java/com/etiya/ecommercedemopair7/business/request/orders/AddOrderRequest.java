package com.etiya.ecommercedemopair7.business.request.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    @Min(value = 1, message = "Sepet tutarı 0 TL'den düşük olamaz !")
    private double totalPrice;
    @Min(1)
    private int deliveryOptionId;
    @Min(1)
    private int orderAddressId;
    @Min(1)
    private int invoiceAddressId;
    @Min(1)
    private int paymentId;

}
