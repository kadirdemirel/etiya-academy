package business;

import entities.Customer;

import java.util.List;

public interface ICustomerService {
    void add(Customer customer);

    void update(int customerId, Customer customer);

    void delete(int customerId);

    List<Customer> getAll();

    Customer getById(int customerId);
}
