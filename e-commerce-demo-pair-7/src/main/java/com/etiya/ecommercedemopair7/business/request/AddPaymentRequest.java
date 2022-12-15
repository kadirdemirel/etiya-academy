package com.etiya.ecommercedemopair7.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentRequest {
    @Min(1)
    private int deliveryOptionId;
    @Min(1)
    private int orderAddressId;
    @Min(1)
    private int invoiceAddressId;
    @Min(1)
    private int paymentTypeId;
    @Min(1)
    private int customerId;
    private boolean isVerified;

}
