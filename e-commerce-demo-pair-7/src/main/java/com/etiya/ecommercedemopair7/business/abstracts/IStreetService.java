package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.streets.GetStreetResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Street;

public interface IStreetService {
    DataResult<GetStreetResponse> getById(int streetId);
    Street getByStreetId(int streetId);
}
