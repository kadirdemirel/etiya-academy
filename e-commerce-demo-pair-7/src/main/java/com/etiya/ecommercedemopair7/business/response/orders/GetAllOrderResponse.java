package com.etiya.ecommercedemopair7.business.response.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrderResponse {
    private int id;
    private String orderNumber;
    private double totalPrice;
    private LocalDate orderDate;
    private int deliveryOptionId;
    private int orderAddressId;
    private int invoiceAddressId;
}
