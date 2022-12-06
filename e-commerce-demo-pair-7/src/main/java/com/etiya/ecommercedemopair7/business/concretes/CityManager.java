package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICityService;
import com.etiya.ecommercedemopair7.entities.concretes.City;
import com.etiya.ecommercedemopair7.repository.abstracts.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityManager implements ICityService {

    private ICityRepository cityRepository;

    @Autowired
    public CityManager(ICityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @Override
    public City getById(int cityId) {
        return checkIfCityExistsById(cityId);
    }

    private City checkIfCityExistsById(int id) {
        City currentCity = this.cityRepository.findById(id).orElseThrow();
        return currentCity;
    }
}

