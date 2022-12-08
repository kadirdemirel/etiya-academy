package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ICountryService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.response.countries.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Paths.apiPrefix + "countries")
public class CountriesController {

    private ICountryService countryService;

    @Autowired
    public CountriesController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{id}")
    public GetCountryResponse getById(@PathVariable int id) {
        return this.countryService.getById(id);
    }
}
