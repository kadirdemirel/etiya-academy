package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICountryService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.response.countries.GetAllCountryResponse;
import com.etiya.ecommercedemopair7.business.response.countries.GetCountryResponse;
import com.etiya.ecommercedemopair7.core.utilities.exceptions.BusinessException;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Country;
import com.etiya.ecommercedemopair7.repository.abstracts.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryManager implements ICountryService {

    private ICountryRepository countryRepository;
    private IModelMapperService modelMapperService;
    private IMessageSourceService messageSourceService;

    @Autowired
    public CountryManager(ICountryRepository countryRepository,
                          IModelMapperService modelMapperService, IMessageSourceService messageSourceService) {
        this.countryRepository = countryRepository;
        this.modelMapperService = modelMapperService;
        this.messageSourceService = messageSourceService;
    }

    @Override
    public DataResult<GetCountryResponse> getById(int countryId) {
        Country country = checkIfCountryExistsById(countryId);
        GetCountryResponse response = modelMapperService.forResponse().map(country, GetCountryResponse.class);
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Country.countryReceived));
    }

    @Override
    public DataResult<List<GetAllCountryResponse>> getAll() {
        List<Country> countries = this.countryRepository.findAll();
        List<GetAllCountryResponse> response = countries.stream().map(country -> this.modelMapperService
                .forResponse().map(country, GetAllCountryResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Country.countriesListed));
    }

    private Country checkIfCountryExistsById(int id) {
        Country currentCountry;
        try {
            currentCountry = this.countryRepository.findById(id).get();
        } catch (Exception e) {
            throw new BusinessException(messageSourceService.getMessage(Messages.Country.countryNotFound));
        }
        return currentCountry;


    }
}
