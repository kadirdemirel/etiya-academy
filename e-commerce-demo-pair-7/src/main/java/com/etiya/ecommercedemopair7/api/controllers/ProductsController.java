package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IProductService;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private IProductService IProductService;

    @Autowired
    ProductsController(IProductService IProductService) {
        this.IProductService = IProductService;
    }

    @GetMapping("/getall")
    public List<Product> getAll() {
        return this.IProductService.getAll();
    }

    @GetMapping("/geybyid")
    public Product getById(@RequestParam int productId) {
        return this.IProductService.getById(productId);
    }

    @GetMapping("/geybyname")
    public Product getByName(@RequestParam String name) {
        return this.IProductService.getByName(name);
    }
    @GetMapping("custom-get-by-name")
    public Product customGetByName(@RequestParam("name") String name){
        return IProductService.customGetByName(name);
    }
}
