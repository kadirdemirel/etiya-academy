package com.etiya.ecommercedemopair7.business.request.productCategories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductCategoryRequest {
    @Min(1)
    private int productId;
    @Min(1)
    private int categoryId;
}
