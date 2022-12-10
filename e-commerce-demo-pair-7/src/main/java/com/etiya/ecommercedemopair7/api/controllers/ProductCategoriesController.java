package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IProductCategoryService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.productCategories.AddProductCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.productCategories.AddProductCategoryResponse;
import com.etiya.ecommercedemopair7.business.response.productCategories.GetAllProductCategoryResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "product-categories")
public class ProductCategoriesController {

    private IProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoriesController(IProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/{categoryId}")
    public DataResult<ProductCategory> getByCategoryId(@PathVariable int categoryId) {
        return productCategoryService.getByCategoryId(categoryId);

    }

    @GetMapping("/get-by-product")
    public DataResult<ProductCategory> getByProductId(@RequestParam("id") int id) {
        return productCategoryService.getByProductId(id);
    }

    @GetMapping("/get-all")
    public DataResult<List<GetAllProductCategoryResponse>> getAll() {
        return productCategoryService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid AddProductCategoryRequest addProductCategoryRequest) {
        return new ResponseEntity<>(productCategoryService.add(addProductCategoryRequest), HttpStatus.CREATED);
    }
}
