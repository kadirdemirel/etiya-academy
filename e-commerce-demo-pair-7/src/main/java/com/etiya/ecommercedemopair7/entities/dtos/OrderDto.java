package com.etiya.ecommercedemopair7.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    private int id;
    private int orderNumber;
    private double totalPrice;
    private LocalDate orderDate;
    private String deliveryOptionName;
    private AddressDto invoiceAddressDto;
    private AddressDto orderAddressDto;
    private List<OrderItemDto> orderItemDto;

}
