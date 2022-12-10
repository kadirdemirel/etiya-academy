package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.productCategories.AddProductCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.orders.GetAllOrderResponse;
import com.etiya.ecommercedemopair7.business.response.productCategories.AddProductCategoryResponse;
import com.etiya.ecommercedemopair7.business.response.productCategories.GetAllProductCategoryResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    DataResult<ProductCategory> getByCategoryId(int categoryId);

    DataResult<ProductCategory> getByProductId(int productId);

    DataResult<AddProductCategoryResponse> add(AddProductCategoryRequest addProductCategoryRequest);

    DataResult<List<GetAllProductCategoryResponse>> getAll();
}
