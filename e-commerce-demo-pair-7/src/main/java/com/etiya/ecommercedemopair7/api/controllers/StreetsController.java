package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IStreetService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.response.streets.GetStreetResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "streets")
public class StreetsController {

    private IStreetService streetService;

    @Autowired
    public StreetsController(IStreetService streetService) {
        this.streetService = streetService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<GetStreetResponse>> getById(@PathVariable int id) {
        return ResponseEntity.ok(this.streetService.getById(id));
    }
}

