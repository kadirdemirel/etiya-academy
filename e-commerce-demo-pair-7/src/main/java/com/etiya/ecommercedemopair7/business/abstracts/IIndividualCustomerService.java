package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.individualCustomers.AddIndividualCustomerRequest;
import com.etiya.ecommercedemopair7.business.response.individualCustomers.AddIndividualCustomerResponse;

public interface IIndividualCustomerService {
    AddIndividualCustomerResponse add(AddIndividualCustomerRequest addIndividualCustomerRequest);
}
