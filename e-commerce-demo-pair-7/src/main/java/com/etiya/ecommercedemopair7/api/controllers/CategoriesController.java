package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ICategoryService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.categories.AddCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.categories.AddCategoryResponse;
import com.etiya.ecommercedemopair7.business.response.categories.GetAllCategoryResponse;
import com.etiya.ecommercedemopair7.business.response.categories.GetCategoryResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "categories")
public class CategoriesController {

    private ICategoryService categoryService;

    @Autowired
    CategoriesController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<DataResult<List<GetAllCategoryResponse>>> getAll() {
        return ResponseEntity.ok(this.categoryService.getAll());
    }

    @GetMapping("/geybyid")
    public ResponseEntity<DataResult<GetCategoryResponse>> getById(@RequestParam int categoryId) {
        return ResponseEntity.ok(this.categoryService.getById(categoryId));
    }

    @GetMapping("get-by-name")
    public ResponseEntity<DataResult<Category>> getByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(this.categoryService.getByName(name));
    }

    @GetMapping("custom-get-by-name")
    public ResponseEntity<DataResult<Category>> customGetByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(this.categoryService.customGetByName(name));
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddCategoryResponse>> add(@RequestBody AddCategoryRequest addCategoryRequest) {
        return new ResponseEntity<>(categoryService.add(addCategoryRequest), HttpStatus.CREATED);
    }

}
