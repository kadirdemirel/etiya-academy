package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBasketRepository extends JpaRepository<Basket,Integer> {

}
