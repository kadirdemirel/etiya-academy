package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category getById(int categoryId);

    Category getByName(String name);

    Category customGetByName(String name);

}
