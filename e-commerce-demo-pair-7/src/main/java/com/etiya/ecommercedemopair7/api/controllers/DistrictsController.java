package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IDistrictService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.response.districts.GetAllDistrictResponse;
import com.etiya.ecommercedemopair7.business.response.districts.GetDistrictResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.concretes.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "districts")
public class DistrictsController {

    private IDistrictService districtService;

    @Autowired
    public DistrictsController(IDistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/{id}")
    public DataResult<GetDistrictResponse> getById(@PathVariable int id) {
        return this.districtService.getById(id);
    }

    @GetMapping("/get-all")
    public DataResult<List<GetAllDistrictResponse>> getAll() {
        return this.districtService.getAll();
    }
}
