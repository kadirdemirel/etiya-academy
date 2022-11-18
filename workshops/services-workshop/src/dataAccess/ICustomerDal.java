package dataAccess;

import entities.Customer;

import java.util.List;

public interface ICustomerDal {
    void add(Customer customer);

    void update(int customerId, Customer customer);

    void delete(int customerId);

    List<Customer> getAll();

    Customer getById(int customerId);
}
