package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.countries.GetAllCountryResponse;
import com.etiya.ecommercedemopair7.business.response.countries.GetCountryResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;

import java.util.List;

public interface ICountryService {
    DataResult<List<GetAllCountryResponse>> getAll();
    DataResult<GetCountryResponse> getById(int countryId);
}
