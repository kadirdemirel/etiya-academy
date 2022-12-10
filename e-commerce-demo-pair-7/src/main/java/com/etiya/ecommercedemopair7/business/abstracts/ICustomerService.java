package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.categories.GetAllCategoryResponse;
import com.etiya.ecommercedemopair7.business.response.customers.GetAllCustomerResponse;
import com.etiya.ecommercedemopair7.business.response.customers.GetCustomerResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Customer;

import java.util.List;

public interface ICustomerService {
    DataResult<GetCustomerResponse> getById(int customerId);
    DataResult<List<GetAllCustomerResponse>> getAll();
}
