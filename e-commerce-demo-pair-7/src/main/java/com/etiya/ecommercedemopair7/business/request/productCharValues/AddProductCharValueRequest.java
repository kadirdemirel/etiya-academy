package com.etiya.ecommercedemopair7.business.request.productCharValues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductCharValueRequest {
        private String name;
        private int productCharId;
}
