package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ProductService;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<Product> getAll() {
        return this.productService.getAll();
    }

    @GetMapping("/geybyid")
    public Product getById(@RequestParam int productId) {
        return this.productService.getById(productId);
    }

    @GetMapping("/geybyname")
    public Product getByName(@RequestParam String name) {
        return this.productService.getByName(name);
    }
    @GetMapping("custom-get-by-name")
    public Product customGetByName(@RequestParam("name") String name){
        return productService.customGetByName(name);
    }
}
