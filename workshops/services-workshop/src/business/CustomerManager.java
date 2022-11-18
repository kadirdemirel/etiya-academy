package business;

import dataAccess.ICustomerDal;
import entities.Customer;

import java.util.List;

public class CustomerManager implements ICustomerService {

    private ICustomerDal customerDal;

    public CustomerManager(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }

    @Override
    public void add(Customer customer) {
        customerDal.add(customer);
    }

    @Override
    public void update(int customerId, Customer customer) {
        customerDal.update(customerId, customer);
    }

    @Override
    public void delete(int customerId) {
        customerDal.delete(customerId);
    }

    @Override
    public List<Customer> getAll() {
        return customerDal.getAll();
    }

    @Override
    public Customer getById(int customerId) {
        return customerDal.getById(customerId);
    }
}
