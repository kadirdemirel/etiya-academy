package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.countries.GetCountryResponse;

public interface ICountryService {
    GetCountryResponse getById(int countryId);
}
