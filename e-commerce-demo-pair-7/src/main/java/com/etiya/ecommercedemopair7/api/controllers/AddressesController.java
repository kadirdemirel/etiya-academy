package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IAddressService;
import com.etiya.ecommercedemopair7.business.request.addresses.AddAddressRequest;
import com.etiya.ecommercedemopair7.business.response.addresses.AddAddressResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/addresses")
public class AddressesController {

    private IAddressService addressService;

    @Autowired
    public AddressesController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<AddAddressResponse> add(@RequestBody @Valid AddAddressRequest addAddressRequest) {
        return new ResponseEntity<AddAddressResponse>(addressService.add(addAddressRequest), HttpStatus.CREATED);
    }
}
