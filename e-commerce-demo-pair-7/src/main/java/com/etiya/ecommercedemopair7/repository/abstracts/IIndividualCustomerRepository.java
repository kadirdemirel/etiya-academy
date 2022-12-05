package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIndividualCustomerRepository extends JpaRepository<IndividualCustomer, Integer> {
}
