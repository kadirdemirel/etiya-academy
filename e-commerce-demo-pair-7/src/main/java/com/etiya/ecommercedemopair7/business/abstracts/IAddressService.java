package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.addresses.AddAddressRequest;
import com.etiya.ecommercedemopair7.business.response.addresses.AddAddressResponse;
import com.etiya.ecommercedemopair7.business.response.addresses.GetAddressResponse;
import com.etiya.ecommercedemopair7.business.response.addresses.GetAllAddressResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Address;

import java.util.List;

public interface IAddressService {
    List<GetAllAddressResponse> getAll();
    GetAddressResponse getById(int addressId);
    Address getByAddressId(int addressId);
    AddAddressResponse add(AddAddressRequest addAddressRequest);
}
