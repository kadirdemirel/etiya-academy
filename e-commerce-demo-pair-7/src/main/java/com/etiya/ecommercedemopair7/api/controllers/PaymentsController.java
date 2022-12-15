package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IPaymentService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.AddPaymentRequest;
import com.etiya.ecommercedemopair7.business.response.payments.AddPaymentResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "payments")
public class PaymentsController {
    private IPaymentService paymentService;

    public PaymentsController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/add")
    ResponseEntity<DataResult<AddPaymentResponse>> add(@RequestBody AddPaymentRequest addPaymentRequest) {
        return new ResponseEntity<>(paymentService.add(addPaymentRequest), HttpStatus.CREATED);
    }
}
