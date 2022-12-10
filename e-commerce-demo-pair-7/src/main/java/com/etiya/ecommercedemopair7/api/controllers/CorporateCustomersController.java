package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ICorporateCustomerService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.corporateCustomers.AddCorporateCustomerRequest;
import com.etiya.ecommercedemopair7.business.response.corporateCustomers.GetAllCorporateCustomerResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "corporate-customers")
public class CorporateCustomersController {

    private ICorporateCustomerService corporateCustomerService;

    public CorporateCustomersController(ICorporateCustomerService corporateCustomerService) {
        this.corporateCustomerService = corporateCustomerService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AddCorporateCustomerRequest addCorporateCustomerRequest) {
        return new ResponseEntity<>(corporateCustomerService.add(addCorporateCustomerRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public DataResult<List<GetAllCorporateCustomerResponse>> getAll() {
        return this.corporateCustomerService.getAll();
    }
}
