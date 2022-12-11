package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ITownService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.response.towns.GetTownResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "towns")
public class TownsController {

    private ITownService townService;

    @Autowired
    public TownsController(ITownService townService) {
        this.townService = townService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<GetTownResponse>> getById(@PathVariable int id) {
        return ResponseEntity.ok(this.townService.getById(id));
    }
}