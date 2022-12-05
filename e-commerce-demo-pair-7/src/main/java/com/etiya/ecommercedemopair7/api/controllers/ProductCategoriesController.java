package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IProductCategoryService;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productcategories")
public class ProductCategoriesController {

    private IProductCategoryService IProductCategoryService;

    @Autowired
    public ProductCategoriesController(IProductCategoryService IProductCategoryService) {
        this.IProductCategoryService = IProductCategoryService;
    }

    @GetMapping("/{categoryId}")
    public ProductCategory getByCategoryId(@PathVariable int categoryId) {
        return IProductCategoryService.getByCategoryId(categoryId);

    }

    @GetMapping("/get-by-product")
    public ProductCategory getByProductId(@RequestParam("id") int id) {
        return IProductCategoryService.getByProductId(id);

    }
}
