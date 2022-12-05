package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IDeliveryOptionService;
import com.etiya.ecommercedemopair7.business.request.deliveryOptions.AddDeliveryOptionRequest;
import com.etiya.ecommercedemopair7.business.response.deliveryOptions.AddDeliveryOptionResponse;
import com.etiya.ecommercedemopair7.entities.concretes.DeliveryOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delivery-options")
public class DeliveryOptionsController {
    private IDeliveryOptionService deliveryOptionService;

    @Autowired
    public DeliveryOptionsController(IDeliveryOptionService deliveryOptionService) {
        this.deliveryOptionService = deliveryOptionService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddDeliveryOptionResponse> add(@RequestBody AddDeliveryOptionRequest addDeliveryOptionRequest) {
        return new ResponseEntity<AddDeliveryOptionResponse>(deliveryOptionService.add(addDeliveryOptionRequest), HttpStatus.CREATED);
    }
}
