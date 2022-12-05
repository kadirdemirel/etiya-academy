package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ICorporateCustomerService;
import com.etiya.ecommercedemopair7.business.request.corporateCustomers.AddCorporateCustomerRequest;
import com.etiya.ecommercedemopair7.business.response.corporateCustomers.AddCorporateCustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/corporate-customers")
public class CorporateCustomersController {

    private ICorporateCustomerService corporateCustomerService;

    public CorporateCustomersController(ICorporateCustomerService corporateCustomerService) {
        this.corporateCustomerService = corporateCustomerService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddCorporateCustomerResponse> add(@RequestBody AddCorporateCustomerRequest addCorporateCustomerRequest) {
        return new ResponseEntity<AddCorporateCustomerResponse>(corporateCustomerService.add(addCorporateCustomerRequest), HttpStatus.CREATED);
    }
}
