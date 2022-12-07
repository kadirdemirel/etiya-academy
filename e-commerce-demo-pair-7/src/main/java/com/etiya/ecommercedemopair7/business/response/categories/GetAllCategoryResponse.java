package com.etiya.ecommercedemopair7.business.response.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCategoryResponse {
    private int id;
    private int refId;
    private String name;
}
