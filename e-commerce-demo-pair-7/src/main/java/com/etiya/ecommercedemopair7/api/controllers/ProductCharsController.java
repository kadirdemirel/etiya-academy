package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IProductCharService;

import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.productChars.AddProductCharRequest;
import com.etiya.ecommercedemopair7.business.response.productChars.GetProductCharResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Paths.apiPrefix + "product-chars")
public class ProductCharsController {
    private IProductCharService productCharService;

    @Autowired
    public ProductCharsController(IProductCharService productCharService) {
        this.productCharService = productCharService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AddProductCharRequest addProductCharRequest) {
        return new ResponseEntity<>(productCharService.add(addProductCharRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id")
    public DataResult<GetProductCharResponse> getById(int productCharId) {
        return productCharService.getById(productCharId);
    }
}

