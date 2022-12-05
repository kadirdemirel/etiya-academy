package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
}
