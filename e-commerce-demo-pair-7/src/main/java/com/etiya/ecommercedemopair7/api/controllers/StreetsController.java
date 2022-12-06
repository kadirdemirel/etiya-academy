package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IStreetService;
import com.etiya.ecommercedemopair7.entities.concretes.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/streets")
public class StreetsController {

    private IStreetService streetService;

    @Autowired
    public StreetsController(IStreetService streetService){
        this.streetService = streetService;
    }

    @GetMapping("/{id}")
    public Street getById(@PathVariable int id) {
        return this.streetService.getById(id);
    }
}

