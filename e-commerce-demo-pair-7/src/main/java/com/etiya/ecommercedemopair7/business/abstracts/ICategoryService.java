package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.categories.AddCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.categories.AddCategoryResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();

    Category getById(int categoryId);

    Category getByName(String name);

    Category customGetByName(String name);

    AddCategoryResponse add(AddCategoryRequest addCategoryRequest);

}
