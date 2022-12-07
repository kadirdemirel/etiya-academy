package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.districts.GetDistrictResponse;
import com.etiya.ecommercedemopair7.entities.concretes.District;

public interface IDistrictService {
    GetDistrictResponse getById(int districtId);
}
