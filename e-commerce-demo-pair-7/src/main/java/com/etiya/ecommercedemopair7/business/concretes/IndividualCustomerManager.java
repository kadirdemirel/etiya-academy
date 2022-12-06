package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IIndividualCustomerService;
import com.etiya.ecommercedemopair7.business.request.individualCustomers.AddIndividualCustomerRequest;
import com.etiya.ecommercedemopair7.business.response.individualCustomers.AddIndividualCustomerResponse;
import com.etiya.ecommercedemopair7.entities.concretes.IndividualCustomer;
import com.etiya.ecommercedemopair7.repository.abstracts.IIndividualCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualCustomerManager implements IIndividualCustomerService {

    private IIndividualCustomerRepository individualCustomerRepository;

    @Autowired
    IndividualCustomerManager(IIndividualCustomerRepository individualCustomerRepository) {
        this.individualCustomerRepository = individualCustomerRepository;
    }

    @Override
    public AddIndividualCustomerResponse add(AddIndividualCustomerRequest addIndividualCustomerRequest) {
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setEmail(addIndividualCustomerRequest.getEmail());
        individualCustomer.setPassword(addIndividualCustomerRequest.getPassword());
        individualCustomer.setNumber(addIndividualCustomerRequest.getNumber());
        individualCustomer.setFirstName(addIndividualCustomerRequest.getFirstName());
        individualCustomer.setLastName(addIndividualCustomerRequest.getLastName());
        individualCustomer.setIdentity(addIndividualCustomerRequest.getIdentity());
        individualCustomer.setBirthDate(addIndividualCustomerRequest.getBirthDate());

        IndividualCustomer savedIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        return new AddIndividualCustomerResponse(
                savedIndividualCustomer.getEmail(), savedIndividualCustomer.getNumber(), savedIndividualCustomer.getFirstName(),
                savedIndividualCustomer.getLastName(), savedIndividualCustomer.getIdentity(), savedIndividualCustomer.getBirthDate()
        );
    }
}
