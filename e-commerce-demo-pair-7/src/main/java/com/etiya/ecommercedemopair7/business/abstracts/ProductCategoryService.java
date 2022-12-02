package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;

public interface ProductCategoryService {
    ProductCategory getByCategoryId(int categoryId);
    ProductCategory getByProductId(int productId);
}
