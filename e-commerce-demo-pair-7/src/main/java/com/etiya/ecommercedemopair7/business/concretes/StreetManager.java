package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IStreetService;
import com.etiya.ecommercedemopair7.business.response.streets.GetStreetResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.Street;
import com.etiya.ecommercedemopair7.repository.abstracts.IStreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreetManager implements IStreetService {
    private IStreetRepository streetRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    StreetManager(IStreetRepository streetRepository, IModelMapperService modelMapperService) {
        this.streetRepository = streetRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public GetStreetResponse getById(int streetId) {
        Street seller = checkIfStreetExistsById(streetId);
        GetStreetResponse response = modelMapperService.forResponse().map(seller, GetStreetResponse.class);
        return response;

    }

    @Override
    public Street getByStreetId(int streetId) {
        return checkIfStreetExistsById(streetId);
    }

    private Street checkIfStreetExistsById(int id) {
        Street currentStreet = this.streetRepository.findById(id).orElseThrow();
        return currentStreet;
    }
}