package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.addresses.AddAddressRequest;
import com.etiya.ecommercedemopair7.business.response.addresses.AddAddressResponse;
import com.etiya.ecommercedemopair7.business.response.addresses.GetAddressResponse;
import com.etiya.ecommercedemopair7.business.response.addresses.GetAllAddressResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Address;
import com.etiya.ecommercedemopair7.entities.dtos.AddressDto;

import java.util.List;

public interface IAddressService {
    DataResult<List<GetAllAddressResponse>> getAll();

    DataResult<GetAddressResponse> getById(int addressId);

    Address getByAddressId(int addressId);

    DataResult<AddAddressResponse> add(AddAddressRequest addAddressRequest);

    DataResult<List<AddressDto>> getAddressDto();
    Address getByUserId(int userId);
}
