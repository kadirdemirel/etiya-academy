package com.etiya.ecommercedemopair7.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDto {
    private int id;
    private String productName;
    private String productCharName;
    private String productCharDescription;
    private String productCharValueName;
}
