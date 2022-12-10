package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.cities.GetAllCityResponse;
import com.etiya.ecommercedemopair7.business.response.cities.GetCityResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;

import java.util.List;

public interface ICityService {
    DataResult<GetCityResponse> getById(int cityId);

    DataResult<List<GetAllCityResponse>> getAll();
}
