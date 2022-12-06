package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Country;

public interface ICountryService {
    Country getById(int countryId);
}
