package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICountryService;
import com.etiya.ecommercedemopair7.entities.concretes.Country;
import com.etiya.ecommercedemopair7.entities.concretes.User;
import com.etiya.ecommercedemopair7.repository.abstracts.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryManager implements ICountryService {

    private ICountryRepository countryRepository;

    @Autowired
    public CountryManager(ICountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Override
    public Country getById(int countryId) {
        return checkIfCountryExistsById(countryId);
    }

    private Country checkIfCountryExistsById(int id) {
        Country currentCountry = this.countryRepository.findById(id).orElseThrow();
        return currentCountry;
    }
}
