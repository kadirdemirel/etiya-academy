package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICategoryService;
import com.etiya.ecommercedemopair7.business.request.categories.AddCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.categories.AddCategoryResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Category;
import com.etiya.ecommercedemopair7.repository.abstracts.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {
    private ICategoryRepository ICategoryRepository;

    @Autowired
    CategoryManager(ICategoryRepository ICategoryRepository) {
        this.ICategoryRepository = ICategoryRepository;
    }


    @Override
    public List<Category> getAll() {
        return this.ICategoryRepository.findAll();
    }

    @Override
    public Category getById(int categoryId) {
        return this.ICategoryRepository.findById(categoryId).orElseThrow();
    }

    @Override
    public Category getByName(String name) {
        return ICategoryRepository.findByName(name);
    }

    @Override
    public Category customGetByName(String name) {
        return ICategoryRepository.customFindByName(name);
    }

    @Override
    public AddCategoryResponse add(AddCategoryRequest addCategoryRequest) {
        Category category = new Category();
        category.setName(addCategoryRequest.getName());
        category.setRefId(addCategoryRequest.getRefId());

        Category save = ICategoryRepository.save(category);
        AddCategoryResponse response = new AddCategoryResponse(save.getId(), save.getRefId(), save.getName());
        return response;
    }
}
