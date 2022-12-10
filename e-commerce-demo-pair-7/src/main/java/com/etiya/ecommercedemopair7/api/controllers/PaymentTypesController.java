package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IPaymentTypeService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.paymentTypes.AddPaymentTypeRequest;
import com.etiya.ecommercedemopair7.business.response.paymentTypes.GetAllPaymentTypeResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "payment-types")
public class PaymentTypesController  {
    private IPaymentTypeService paymentTypeService;

    @Autowired
    public PaymentTypesController(IPaymentTypeService paymentTypeService){
        this.paymentTypeService = paymentTypeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AddPaymentTypeRequest addPaymentTypeRequest) {
        return new ResponseEntity<>(paymentTypeService.add(addPaymentTypeRequest), HttpStatus.CREATED);
    }
    @GetMapping("/get-all")
    public DataResult<List<GetAllPaymentTypeResponse>> getAll() {
        return this.paymentTypeService.getAll();
    }
}
