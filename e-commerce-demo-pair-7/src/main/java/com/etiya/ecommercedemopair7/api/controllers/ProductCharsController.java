package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IProductCharService;

import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.productChars.AddProductCharRequest;
import com.etiya.ecommercedemopair7.business.response.productChars.AddProductCharResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "product-chars")
public class ProductCharsController {
    private IProductCharService productCharService;

    @Autowired
    public ProductCharsController(IProductCharService productCharService) {
        this.productCharService = productCharService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddProductCharResponse> add(@RequestBody AddProductCharRequest addProductCharRequest) {
        return new ResponseEntity<AddProductCharResponse>(productCharService.add(addProductCharRequest), HttpStatus.CREATED);
    }
}

