package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICategoryService;
import com.etiya.ecommercedemopair7.business.request.categories.AddCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.categories.AddCategoryResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.Category;
import com.etiya.ecommercedemopair7.repository.abstracts.ICategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CategoryManager implements ICategoryService {
    private ICategoryRepository categoryRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    CategoryManager(ICategoryRepository categoryRepository, IModelMapperService modelMapperService) {
        this.categoryRepository = categoryRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getById(int categoryId) {
        return existsByCategoryId(categoryId);
    }

    @Override
    public Category getByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category customGetByName(String name) {
        return categoryRepository.customFindByName(name);
    }

    @Override
    public AddCategoryResponse add(AddCategoryRequest addCategoryRequest) {
        Category category = modelMapperService.forRequest().map(addCategoryRequest, Category.class);
        categoryCanNotExistWithSameName(addCategoryRequest.getName());
        Category savedCategory = categoryRepository.save(category);
        AddCategoryResponse response = modelMapperService.forResponse().map(savedCategory, AddCategoryResponse.class);
        return response;
    }

    private void categoryCanNotExistWithSameName(String name) {
        boolean isExists = categoryRepository.existsCategoryByName(name);
        if (isExists)
            throw new RuntimeException("Bu isimle bir kategori zaten mevcut!");
    }

    private Category existsByCategoryId(int id) {
        Category currentCategory;
        try {
            currentCategory = this.categoryRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("İlgili kategori bulunamadı.");
        }
        return currentCategory;
    }
}
