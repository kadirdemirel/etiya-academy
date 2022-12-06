package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IAddressService;
import com.etiya.ecommercedemopair7.business.abstracts.IStreetService;
import com.etiya.ecommercedemopair7.business.abstracts.IUserService;
import com.etiya.ecommercedemopair7.business.request.addresses.AddAddressRequest;
import com.etiya.ecommercedemopair7.business.response.addresses.AddAddressResponse;
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

    @Autowired
    AddressManager(IAddressRepository addressRepository, IStreetService streetService, IUserService userService) {
        this.addressRepository = addressRepository;
        this.streetService = streetService;
        this.userService = userService;
    }

    @Override
    public Address getById(int addressId) {
        return checkIfAddressExistsById(addressId);
    }

    @Override
    public AddAddressResponse add(AddAddressRequest addAddressRequest) {
        Address address = new Address();
        address.setAddress(addAddressRequest.getAddress());
        address.setTitle(addAddressRequest.getTitle());

        Street street = getStreet(addAddressRequest.getStreetId());
        address.setStreet(street);
        User user = getUser(addAddressRequest.getUserId());
        address.setUser(user);

        Address savedAddress = addressRepository.save(address);

        return new AddAddressResponse(savedAddress.getId(), savedAddress.getTitle(),
                savedAddress.getAddress(), savedAddress.getUser().getId(), savedAddress.getStreet().getId());
    }

    private User getUser(int userId) {
        User user = userService.getById(userId);
        return user;
    }

    private Street getStreet(int streetId) {
        Street street = streetService.getById(streetId);
        return street;
    }

    private Address checkIfAddressExistsById(int addressId) {
        Address currentAddress = this.addressRepository.findById(addressId).orElseThrow();
        return currentAddress;
    }
}
