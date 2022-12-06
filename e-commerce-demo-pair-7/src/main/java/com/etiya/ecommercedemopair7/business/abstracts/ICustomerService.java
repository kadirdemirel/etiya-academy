package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Customer;

public interface ICustomerService {
    Customer getById(int customerId);
}
