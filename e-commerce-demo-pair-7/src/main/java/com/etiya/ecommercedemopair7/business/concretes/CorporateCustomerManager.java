package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICorporateCustomerService;
import com.etiya.ecommercedemopair7.business.request.corporateCustomers.AddCorporateCustomerRequest;
import com.etiya.ecommercedemopair7.business.response.corporateCustomers.AddCorporateCustomerResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.CorporateCustomer;
import com.etiya.ecommercedemopair7.repository.abstracts.ICorporateCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorporateCustomerManager implements ICorporateCustomerService {

    private ICorporateCustomerRepository corporateCustomerRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public CorporateCustomerManager(ICorporateCustomerRepository corporateCustomerRepository, IModelMapperService modelMapperService) {
        this.corporateCustomerRepository = corporateCustomerRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public AddCorporateCustomerResponse add(AddCorporateCustomerRequest addCorporateCustomerRequest) {
        CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(addCorporateCustomerRequest, CorporateCustomer.class);
        CorporateCustomer savedCorporateCustomer = corporateCustomerRepository.save(corporateCustomer);
        AddCorporateCustomerResponse response = modelMapperService.forResponse().map(savedCorporateCustomer, AddCorporateCustomerResponse.class);
        return response;
    }
}
