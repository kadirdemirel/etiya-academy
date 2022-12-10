package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.corporateCustomers.AddCorporateCustomerRequest;
import com.etiya.ecommercedemopair7.business.response.basketItems.GetAllBasketItemResponse;
import com.etiya.ecommercedemopair7.business.response.corporateCustomers.AddCorporateCustomerResponse;
import com.etiya.ecommercedemopair7.business.response.corporateCustomers.GetAllCorporateCustomerResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;

import java.util.List;

public interface ICorporateCustomerService {
    DataResult<AddCorporateCustomerResponse> add(AddCorporateCustomerRequest addCorporateCustomerRequest);

    DataResult<List<GetAllCorporateCustomerResponse>> getAll();
}
