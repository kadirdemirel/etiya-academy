package com.etiya.ecommercedemopair7.business.response.productCategories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data



public class GetAllProductCategoryResponse {
    private int id;
    private int productId;
    private int categoryId;
}
