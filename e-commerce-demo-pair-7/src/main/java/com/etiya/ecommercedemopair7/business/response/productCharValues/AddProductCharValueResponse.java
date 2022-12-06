package com.etiya.ecommercedemopair7.business.response.productCharValues;

import com.etiya.ecommercedemopair7.entities.concretes.ProductChar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AddProductCharValueResponse {
    private int id;
    private String name;
    private int productCharId;
}
