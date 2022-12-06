package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ICityService;
import com.etiya.ecommercedemopair7.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

    private ICityService cityService;

    @Autowired
    public CitiesController(ICityService cityService){
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable int id) {
        return this.cityService.getById(id);
    }
}
