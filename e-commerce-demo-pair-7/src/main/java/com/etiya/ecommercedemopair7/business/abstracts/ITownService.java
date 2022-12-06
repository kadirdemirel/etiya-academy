package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Town;

public interface ITownService {
    Town getById(int townId);
}
