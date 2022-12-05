package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ICategoryService;
import com.etiya.ecommercedemopair7.business.request.categories.AddCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.categories.AddCategoryResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private ICategoryService ICategoryService;

    @Autowired
    CategoriesController(ICategoryService ICategoryService) {
        this.ICategoryService = ICategoryService;
    }

    @GetMapping("/getall")
    public List<Category> getAll() {
        return this.ICategoryService.getAll();
    }

    @GetMapping("/geybyid")
    public Category getById(@RequestParam int categoryId) {
        return this.ICategoryService.getById(categoryId);
    }

    @GetMapping("get-by-name")
    public Category getByName(@RequestParam("name") String name) {
        return ICategoryService.getByName(name);
    }

    @GetMapping("custom-get-by-name")
    public Category customGetByName(@RequestParam("name") String name) {
        return ICategoryService.customGetByName(name);
    }

    @PostMapping("/add")
    public ResponseEntity<AddCategoryResponse> add(@RequestBody AddCategoryRequest addCategoryRequest) {
        return new ResponseEntity<AddCategoryResponse>(ICategoryService.add(addCategoryRequest), HttpStatus.CREATED);
    }

}
