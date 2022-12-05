package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ISellerService;
import com.etiya.ecommercedemopair7.business.request.sellers.AddSellerRequest;
import com.etiya.ecommercedemopair7.business.response.sellers.AddSellerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sellers")
public class SellersController {

    private ISellerService sellerService;

    @Autowired
    public SellersController(ISellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddSellerResponse> add(@RequestBody AddSellerRequest addSellerRequest) {
        return new ResponseEntity<AddSellerResponse>(sellerService.add(addSellerRequest), HttpStatus.CREATED);
    }

}
