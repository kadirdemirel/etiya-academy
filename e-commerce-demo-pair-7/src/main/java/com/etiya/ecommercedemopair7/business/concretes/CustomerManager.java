package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICustomerService;
import com.etiya.ecommercedemopair7.entities.concretes.Customer;
import com.etiya.ecommercedemopair7.repository.abstracts.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {

    private ICustomerRepository customerRepository;

    @Autowired
    public CustomerManager(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getById(int customerId) {
        return checkIfCustomerExistsById(customerId);
    }

    private Customer checkIfCustomerExistsById(int id) {
        Customer currentCustomer;
        try {
            currentCustomer = this.customerRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Böyle bir müşteri yok.");
        }
        return currentCustomer;
    }
}