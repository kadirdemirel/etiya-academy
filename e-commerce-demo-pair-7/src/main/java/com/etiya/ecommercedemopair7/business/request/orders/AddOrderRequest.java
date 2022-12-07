package com.etiya.ecommercedemopair7.business.request.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    private String orderNumber;
    private double totalPrice;
    private LocalDate orderDate;
    private int deliveryOptionId;
    private int orderAddressId;
    private int invoiceAddressId;
}
