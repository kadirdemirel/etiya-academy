package com.etiya.ecommercedemopair7.api.controllers;


import com.etiya.ecommercedemopair7.business.abstracts.ICustomerService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.response.customers.GetAllCustomerResponse;
import com.etiya.ecommercedemopair7.business.response.customers.GetCustomerResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "customers")
public class CustomersController {

    private ICustomerService customerService;

    @Autowired
    public CustomersController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<GetAllCustomerResponse>>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<GetCustomerResponse>> getById(@PathVariable int id) {
        return ResponseEntity.ok(customerService.getById(id));
    }
}
