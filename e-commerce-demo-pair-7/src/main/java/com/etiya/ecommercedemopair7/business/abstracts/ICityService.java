package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.cities.GetCityResponse;

public interface ICityService {
    GetCityResponse getById(int cityId);
}
