package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IIndividualCustomerService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.individualCustomers.AddIndividualCustomerRequest;
import com.etiya.ecommercedemopair7.business.response.individualCustomers.AddIndividualCustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "individual-customers")
public class IndividualCustomersController {

    private IIndividualCustomerService individualCustomerService;

    public IndividualCustomersController(IIndividualCustomerService individualCustomerService) {
        this.individualCustomerService = individualCustomerService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddIndividualCustomerResponse> add(@RequestBody AddIndividualCustomerRequest addIndividualCustomerRequest) {
        return new ResponseEntity<AddIndividualCustomerResponse>(individualCustomerService.add(addIndividualCustomerRequest), HttpStatus.CREATED);
    }
}
