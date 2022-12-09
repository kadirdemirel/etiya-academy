package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.countries.GetAllCountryResponse;
import com.etiya.ecommercedemopair7.business.response.countries.GetCountryResponse;

import java.util.List;

public interface ICountryService {
    List<GetAllCountryResponse> getAll();
    GetCountryResponse getById(int countryId);
}
