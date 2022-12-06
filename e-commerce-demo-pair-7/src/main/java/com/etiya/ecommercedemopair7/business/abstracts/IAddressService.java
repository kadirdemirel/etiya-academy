package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.addresses.AddAddressRequest;
import com.etiya.ecommercedemopair7.business.response.addresses.AddAddressResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Address;

public interface IAddressService {
    Address getById(int addressId);
    AddAddressResponse add(AddAddressRequest addAddressRequest);
}
