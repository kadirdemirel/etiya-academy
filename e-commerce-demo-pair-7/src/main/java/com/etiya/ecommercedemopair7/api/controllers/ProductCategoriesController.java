package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IProductCategoryService;
import com.etiya.ecommercedemopair7.business.request.productCategories.AddProductCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.productCategories.AddProductCategoryResponse;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/productcategories")
public class ProductCategoriesController {

    private IProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoriesController(IProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/{categoryId}")
    public ProductCategory getByCategoryId(@PathVariable int categoryId) {
        return productCategoryService.getByCategoryId(categoryId);

    }

    @GetMapping("/get-by-product")
    public ProductCategory getByProductId(@RequestParam("id") int id) {
        return productCategoryService.getByProductId(id);
    }

    @PostMapping("/add")
    public ResponseEntity<AddProductCategoryResponse> add(@RequestBody @Valid AddProductCategoryRequest addProductCategoryRequest) {
        return new ResponseEntity<AddProductCategoryResponse>(productCategoryService.add(addProductCategoryRequest), HttpStatus.CREATED);
    }
}
