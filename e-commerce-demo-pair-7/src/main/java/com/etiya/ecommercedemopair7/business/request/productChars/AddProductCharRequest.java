package com.etiya.ecommercedemopair7.business.request.productChars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductCharRequest {
    private int id;
    private String name;
    private String description;
}
