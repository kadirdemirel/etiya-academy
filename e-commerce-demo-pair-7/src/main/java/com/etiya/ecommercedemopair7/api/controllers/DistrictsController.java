package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IDistrictService;
import com.etiya.ecommercedemopair7.entities.concretes.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/districts")
public class DistrictsController {

    private IDistrictService districtService;

    @Autowired
    public DistrictsController(IDistrictService districtService){
        this.districtService = districtService;
    }

    @GetMapping("/{id}")
    public District getById(@PathVariable int id) {
        return this.districtService.getById(id);
    }
}
