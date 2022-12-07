package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IIndividualCustomerService;
import com.etiya.ecommercedemopair7.business.request.individualCustomers.AddIndividualCustomerRequest;
import com.etiya.ecommercedemopair7.business.response.corporateCustomers.AddCorporateCustomerResponse;
import com.etiya.ecommercedemopair7.business.response.individualCustomers.AddIndividualCustomerResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.IndividualCustomer;
import com.etiya.ecommercedemopair7.repository.abstracts.IIndividualCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualCustomerManager implements IIndividualCustomerService {

    private IIndividualCustomerRepository individualCustomerRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    IndividualCustomerManager(IIndividualCustomerRepository individualCustomerRepository, IModelMapperService modelMapperService) {
        this.individualCustomerRepository = individualCustomerRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public AddIndividualCustomerResponse add(AddIndividualCustomerRequest addIndividualCustomerRequest) {
        IndividualCustomer individualCustomer = modelMapperService.forRequest().map(addIndividualCustomerRequest, IndividualCustomer.class);
        IndividualCustomer savedIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        AddIndividualCustomerResponse response = modelMapperService.forRequest().map(savedIndividualCustomer, AddIndividualCustomerResponse.class);
        return response;
    }
}
