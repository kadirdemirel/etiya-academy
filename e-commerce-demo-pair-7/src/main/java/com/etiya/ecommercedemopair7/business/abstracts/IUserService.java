package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.User;

public interface IUserService {
    User getById(int id);
}
