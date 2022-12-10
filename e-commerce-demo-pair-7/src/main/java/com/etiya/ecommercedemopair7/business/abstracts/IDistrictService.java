package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.districts.GetAllDistrictResponse;
import com.etiya.ecommercedemopair7.business.response.districts.GetDistrictResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.concretes.District;

import java.util.List;

public interface IDistrictService {
    DataResult<GetDistrictResponse> getById(int districtId);

    DataResult<List<GetAllDistrictResponse>> getAll();

}
