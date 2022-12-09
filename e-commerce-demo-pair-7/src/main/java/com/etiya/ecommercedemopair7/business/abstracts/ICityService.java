package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.cities.GetAllCityResponse;
import com.etiya.ecommercedemopair7.business.response.cities.GetCityResponse;

import java.util.List;

public interface ICityService {
    GetCityResponse getById(int cityId);
    List<GetAllCityResponse> getAll();
}
