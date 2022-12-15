package com.etiya.ecommercedemopair7.business.response.payments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentResponse {
    private int id;
    private int deliveryOptionId;
    private int orderAddressId;
    private int invoiceAddressId;
    private int paymentTypeId;
    private double totalPrice;
    private int customerId;
    private boolean isVerified;

}
