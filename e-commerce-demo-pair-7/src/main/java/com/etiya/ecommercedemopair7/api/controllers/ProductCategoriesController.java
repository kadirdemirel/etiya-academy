package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productcategories")
public class ProductCategoriesController {

    private ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoriesController(ProductCategoryService productCategoryService) {
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
}
