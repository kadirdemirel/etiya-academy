package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.ICityService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.response.cities.GetAllCityResponse;
import com.etiya.ecommercedemopair7.business.response.cities.GetCityResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "cities")
public class CitiesController {

    private ICityService cityService;

    @Autowired
    public CitiesController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public DataResult<GetCityResponse> getById(@PathVariable int id) {
        return this.cityService.getById(id);
    }

    @GetMapping("get-all")
    public DataResult<List<GetAllCityResponse>> getAll() {
        return this.cityService.getAll();
    }
}
