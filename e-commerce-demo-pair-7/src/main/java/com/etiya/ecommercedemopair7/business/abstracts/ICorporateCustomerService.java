package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.corporateCustomers.AddCorporateCustomerRequest;
import com.etiya.ecommercedemopair7.business.response.corporateCustomers.AddCorporateCustomerResponse;

public interface ICorporateCustomerService {
    AddCorporateCustomerResponse add(AddCorporateCustomerRequest addCorporateCustomerRequest);
}
