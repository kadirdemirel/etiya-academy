package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.response.customers.GetCustomerResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Customer;

public interface ICustomerService {
    GetCustomerResponse getById(int customerId);
}
