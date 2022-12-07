package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.towns.GetTownResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Town;

public interface ITownService {
    GetTownResponse getById(int townId);
}
