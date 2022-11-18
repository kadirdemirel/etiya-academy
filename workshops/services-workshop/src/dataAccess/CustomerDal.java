package dataAccess;

import entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDal implements ICustomerDal {

    List<Customer> customers = new ArrayList<>();

    public CustomerDal() {
        customers.add(new Customer(1, "Emre", "Çakıroğlu", 22));
        customers.add(new Customer(2, "Kadir", "Demirel", 25));
        customers.add(new Customer(3, "Emre", "asd", 24));
    }


    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void update(int customerId, Customer customer) {
        customers.set(customerId, customer);
    }

    @Override
    public void delete(int customerId) {
        customers.remove(customerId);
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public Customer getById(int customerId) {
        return customers.get(customerId);
    }
}
