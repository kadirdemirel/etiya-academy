package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ISellerProductService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.sellerProducts.AddSellerProductRequest;
import com.etiya.ecommercedemopair7.business.response.sellerProducts.AddSellerProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Paths.apiPrefix + "seller-products")
public class SellerProductsController {
    private ISellerProductService sellerProductService;

    @Autowired
    SellerProductsController(ISellerProductService sellerProductService) {
        this.sellerProductService = sellerProductService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddSellerProductResponse> add(@RequestBody @Valid AddSellerProductRequest addSellerProductRequest) {
        return new ResponseEntity<AddSellerProductResponse>(sellerProductService.add(addSellerProductRequest), HttpStatus.CREATED);
    }
}
