package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ISellerService;
import com.etiya.ecommercedemopair7.business.request.sellers.AddSellerRequest;
import com.etiya.ecommercedemopair7.business.response.sellers.AddSellerResponse;
import com.etiya.ecommercedemopair7.business.response.sellers.GetSellerResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sellers")
public class SellersController {

    private ISellerService sellerService;

    @Autowired
    public SellersController(ISellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/{id}")
    public GetSellerResponse getById(@PathVariable int id){
        return sellerService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<AddSellerResponse> add(@RequestBody AddSellerRequest addSellerRequest) {
        return new ResponseEntity<AddSellerResponse>(sellerService.add(addSellerRequest), HttpStatus.CREATED);
    }

}
