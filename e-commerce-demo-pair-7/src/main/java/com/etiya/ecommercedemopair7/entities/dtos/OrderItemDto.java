package com.etiya.ecommercedemopair7.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderItemDto {
    private int id;

    private String name;

    private int stock;

    private double unitPrice;

    private int quantity;

    private double itemTotalPrice;

    private double totalPrice;

    private String orderNumber;

    private LocalDate orderDate;

    private String description;


}
