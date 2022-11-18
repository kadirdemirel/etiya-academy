import business.CustomerManager;
import dataAccess.CustomerDal;
import entities.Customer;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CustomerManager customerManager = new CustomerManager(new CustomerDal());

        // Add method
        customerManager.add(new Customer(4, "Engin", "Demiroğ", 35));

        // Update method
        customerManager.update(2, new Customer(4, "Kadir", "Demirel", 25));

        // GetAll method
        List<Customer> customers = customerManager.getAll();

        // GetById method
        Customer customer = customerManager.getById(2);
        System.out.println(customer.getId() + " " + customer.getFirstName() + " " + customer.getLastName() + " " + customer.getAge());

        // Delete method
        customerManager.delete(1);

        for (Customer customer1 : customers) {
            System.out.println(customer1.getFirstName());
        }
    }
}