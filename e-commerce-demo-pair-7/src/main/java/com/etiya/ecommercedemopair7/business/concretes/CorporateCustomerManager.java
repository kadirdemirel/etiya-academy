package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICorporateCustomerService;
import com.etiya.ecommercedemopair7.business.request.corporateCustomers.AddCorporateCustomerRequest;
import com.etiya.ecommercedemopair7.business.response.corporateCustomers.AddCorporateCustomerResponse;
import com.etiya.ecommercedemopair7.entities.concretes.CorporateCustomer;
import com.etiya.ecommercedemopair7.repository.abstracts.ICorporateCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorporateCustomerManager implements ICorporateCustomerService {

    private ICorporateCustomerRepository corporateCustomerRepository;

    @Autowired
    public CorporateCustomerManager(ICorporateCustomerRepository corporateCustomerRepository) {
        this.corporateCustomerRepository = corporateCustomerRepository;
    }

    @Override
    public AddCorporateCustomerResponse add(AddCorporateCustomerRequest addCorporateCustomerRequest) {
        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setEmail(addCorporateCustomerRequest.getEmail());
        corporateCustomer.setPassword(addCorporateCustomerRequest.getPassword());
        corporateCustomer.setNumber(addCorporateCustomerRequest.getNumber());
        corporateCustomer.setName(addCorporateCustomerRequest.getName());
        corporateCustomer.setTaxNumber(addCorporateCustomerRequest.getTaxNumber());

        CorporateCustomer savedCorporateCustomer = corporateCustomerRepository.save(corporateCustomer);

        AddCorporateCustomerResponse response = new AddCorporateCustomerResponse(
                savedCorporateCustomer.getEmail(), savedCorporateCustomer.getNumber(), savedCorporateCustomer.getName(),
                savedCorporateCustomer.getTaxNumber()
        );

        return response;
    }
}
