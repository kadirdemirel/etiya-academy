package com.etiya.ecommercedemopair7.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryDto {
    private int id;
    private String productName;
    private String categoryName;
    private int refId;
}
