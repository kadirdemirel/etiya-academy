package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair7.entities.concretes.Category;
import com.etiya.ecommercedemopair7.repository.abstracts.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    CategoryManager(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getById(int categoryId) {
        return this.categoryRepository.findById(categoryId).orElseThrow();
    }

    @Override
    public Category getByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category customGetByName(String name) {
        return categoryRepository.customFindByName(name);
    }
}
