package com.etiya.ecommercedemopair7.business.response.productCategories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductCategoryResponse {
    private int id;
    private int productId;
    private int categoryId;
}
