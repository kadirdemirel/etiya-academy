package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.productCategories.AddProductCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.productCategories.AddProductCategoryResponse;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;

public interface IProductCategoryService {
    ProductCategory getByCategoryId(int categoryId);

    ProductCategory getByProductId(int productId);

    AddProductCategoryResponse add(AddProductCategoryRequest addProductCategoryRequest);
}
