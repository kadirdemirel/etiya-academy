package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICityService;
import com.etiya.ecommercedemopair7.business.response.cities.GetCityResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.City;
import com.etiya.ecommercedemopair7.repository.abstracts.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityManager implements ICityService {

    private ICityRepository cityRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public CityManager(ICityRepository cityRepository, IModelMapperService modelMapperService) {
        this.cityRepository = cityRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public GetCityResponse getById(int cityId) {
        City city = checkIfCityExistsById(cityId);
        GetCityResponse response = modelMapperService.forResponse().map(city, GetCityResponse.class);
        return response;
    }

    private City checkIfCityExistsById(int id) {
        City currentCity = this.cityRepository.findById(id).orElseThrow();
        return currentCity;
    }
}

