package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IProductService;
import com.etiya.ecommercedemopair7.business.request.products.AddProductRequest;
import com.etiya.ecommercedemopair7.business.response.products.AddProductResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private IProductService productService;

    @Autowired
    ProductsController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<Product> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/get-by-id")
    public Product getById(@RequestParam int productId) {
        return this.productService.getById(productId);
    }

    @GetMapping("/get-by-name")
    public Product getByName(@RequestParam String name) {
        return this.productService.getByName(name);
    }

    @GetMapping("custom-get-by-name")
    public Product customGetByName(@RequestParam("name") String name) {
        return productService.customGetByName(name);
    }

    @PostMapping("/add")
    public ResponseEntity<AddProductResponse> add(@RequestBody @Valid AddProductRequest addProductRequest) {
        return new ResponseEntity<AddProductResponse>(productService.add(addProductRequest), HttpStatus.CREATED);
    }
}
