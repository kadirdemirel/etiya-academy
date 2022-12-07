package com.etiya.ecommercedemopair7.business.response.productChars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductCharResponse {
    private int id;
    private String name;
    private String description;
}
