package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair7.entities.concretes.Category;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private CategoryService categoryService;

    @Autowired
    CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public List<Category> getAll() {
        return this.categoryService.getAll();
    }

    @GetMapping("/geybyid")
    public Category getById(@RequestParam int categoryId) {
        return this.categoryService.getById(categoryId);
    }

    @GetMapping("get-by-name")
    public Category getByName(@RequestParam("name") String name) {
        return categoryService.getByName(name);
    }

    @GetMapping("custom-get-by-name")
    public Category customGetByName(@RequestParam("name") String name) {
        return categoryService.customGetByName(name);
    }

}
