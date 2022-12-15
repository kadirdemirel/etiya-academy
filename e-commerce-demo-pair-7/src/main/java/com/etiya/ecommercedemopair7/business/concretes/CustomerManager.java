package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICustomerService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.response.customers.GetAllCustomerResponse;
import com.etiya.ecommercedemopair7.business.response.customers.GetCustomerResponse;
import com.etiya.ecommercedemopair7.core.utilities.exceptions.BusinessException;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Customer;
import com.etiya.ecommercedemopair7.repository.abstracts.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements ICustomerService {

    private ICustomerRepository customerRepository;
    private IModelMapperService modelMapperService;
    private IMessageSourceService messageSourceService;

    @Autowired
    public CustomerManager(ICustomerRepository customerRepository,
                           IModelMapperService modelMapperService,
                           IMessageSourceService messageSourceService) {
        this.customerRepository = customerRepository;
        this.modelMapperService = modelMapperService;
        this.messageSourceService = messageSourceService;
    }

    @Override
    public DataResult<GetCustomerResponse> getById(int customerId) {
        Customer customer = checkIfCustomerExistsById(customerId);
        GetCustomerResponse response = modelMapperService.forResponse().map(customer, GetCustomerResponse.class);
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Customer.customerReceived));
    }

    @Override
    public DataResult<List<GetAllCustomerResponse>> getAll() {
        List<Customer> customers = this.customerRepository.findAll();
        List<GetAllCustomerResponse> response = customers.stream().map(customer -> this.modelMapperService.forResponse()
                .map(customer, GetAllCustomerResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Customer.customersListed));
    }

    private Customer checkIfCustomerExistsById(int id) {
        Customer currentCustomer;
        try {
            currentCustomer = this.customerRepository.findById(id).get();
        } catch (Exception e) {
            throw new BusinessException(messageSourceService.getMessage(Messages.Customer.customerNotFound));
        }
        return currentCustomer;
    }
}