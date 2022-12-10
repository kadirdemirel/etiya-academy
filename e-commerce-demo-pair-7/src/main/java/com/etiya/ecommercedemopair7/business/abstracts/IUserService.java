package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.users.GetAllUserResponse;
import com.etiya.ecommercedemopair7.business.response.users.GetUserResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.concretes.User;

import java.util.List;

public interface IUserService {
    DataResult<GetUserResponse> getById(int id);
    public DataResult<List<GetAllUserResponse>> getAll();
    User getByUserId(int id);
}
