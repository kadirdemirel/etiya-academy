package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
}
