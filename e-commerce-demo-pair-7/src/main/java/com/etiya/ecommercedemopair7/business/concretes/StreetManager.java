package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IStreetService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.response.streets.GetStreetResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
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
    public DataResult<GetStreetResponse> getById(int streetId) {
        Street seller = checkIfStreetExistsById(streetId);
        GetStreetResponse response = modelMapperService.forResponse().map(seller, GetStreetResponse.class);
        return new SuccessDataResult<>(response, Messages.Street.streetReceived);
    }

    @Override
    public Street getByStreetId(int streetId) {
        return checkIfStreetExistsById(streetId);
    }

    private Street checkIfStreetExistsById(int id) {
        Street currentStreet;
        try {
            currentStreet = this.streetRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException(Messages.Street.streetNotFound);
        }
        return currentStreet;
    }
}
