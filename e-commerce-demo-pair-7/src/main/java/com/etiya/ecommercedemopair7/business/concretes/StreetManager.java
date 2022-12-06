package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IStreetService;
import com.etiya.ecommercedemopair7.entities.concretes.Street;
import com.etiya.ecommercedemopair7.repository.abstracts.IStreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreetManager implements IStreetService {
    private IStreetRepository streetRepository;

    @Autowired
    StreetManager(IStreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Override
    public Street getById(int streetId) {
        return checkIfStreetExistsById(streetId);
    }

    private Street checkIfStreetExistsById(int id) {
        Street currentStreet = this.streetRepository.findById(id).orElseThrow();
        return currentStreet;
    }
}
