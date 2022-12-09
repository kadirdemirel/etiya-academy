package com.etiya.ecommercedemopair7.business.response.productCharValues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductCharValueResponse {
    private int id;
    private String name;
    private int productCharId;
}
