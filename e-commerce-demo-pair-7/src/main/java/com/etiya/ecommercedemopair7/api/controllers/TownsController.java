package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ITownService;
import com.etiya.ecommercedemopair7.business.response.towns.GetTownResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/towns")
public class TownsController {

    private ITownService townService;

    @Autowired
    public TownsController(ITownService townService){
        this.townService = townService;
    }

    @GetMapping("/{id}")
    public GetTownResponse getById(@PathVariable int id) {
        return this.townService.getById(id);
    }
}