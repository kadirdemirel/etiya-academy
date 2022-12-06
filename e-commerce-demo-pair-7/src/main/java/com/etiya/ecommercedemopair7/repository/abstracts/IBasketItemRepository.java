package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBasketItemRepository extends JpaRepository<BasketItem,Integer> {
}
