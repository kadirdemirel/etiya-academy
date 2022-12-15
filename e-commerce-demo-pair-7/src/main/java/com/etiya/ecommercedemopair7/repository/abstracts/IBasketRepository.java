package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBasketRepository extends JpaRepository<Basket,Integer> {
    Basket findByCustomerId(int customerId);

}
