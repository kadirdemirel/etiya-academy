package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IAddressService;
import com.etiya.ecommercedemopair7.business.abstracts.IStreetService;
import com.etiya.ecommercedemopair7.business.abstracts.IUserService;
import com.etiya.ecommercedemopair7.business.request.addresses.AddAddressRequest;
import com.etiya.ecommercedemopair7.business.response.addresses.AddAddressResponse;
import com.etiya.ecommercedemopair7.business.response.addresses.GetAddressResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.Address;
import com.etiya.ecommercedemopair7.entities.concretes.Street;
import com.etiya.ecommercedemopair7.entities.concretes.User;
import com.etiya.ecommercedemopair7.repository.abstracts.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressManager implements IAddressService {

    private IAddressRepository addressRepository;
    private IStreetService streetService;
    private IUserService userService;
    private IModelMapperService modelMapperService;

    @Autowired
    AddressManager(IAddressRepository addressRepository, IStreetService streetService, IUserService userService, IModelMapperService modelMapperService) {
        this.addressRepository = addressRepository;
        this.streetService = streetService;
        this.userService = userService;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public GetAddressResponse getById(int addressId) {
        Address address = checkIfAddressExistsById(addressId);
        GetAddressResponse response = modelMapperService.forResponse().map(address, GetAddressResponse.class);
        return response;
    }

    @Override
    public Address getByAddressId(int addressId) {
        return checkIfAddressExistsById(addressId);
    }

    @Override
    public AddAddressResponse add(AddAddressRequest addAddressRequest) {
        getStreet(addAddressRequest.getStreetId());
        getUser(addAddressRequest.getUserId());
        Address address = modelMapperService.forRequest().map(addAddressRequest, Address.class);
        Address savedAddress = addressRepository.save(address);
        AddAddressResponse response = modelMapperService.forResponse().map(savedAddress, AddAddressResponse.class);
        return response;
    }

    private User getUser(int userId) {
        User user = userService.getByUserId(userId);
        return user;
    }

    private Street getStreet(int streetId) {
        Street street = streetService.getByStreetId(streetId);
        return street;
    }

    private Address checkIfAddressExistsById(int addressId) {
        Address currentAddress = this.addressRepository.findById(addressId).orElseThrow();
        return currentAddress;
    }
}
