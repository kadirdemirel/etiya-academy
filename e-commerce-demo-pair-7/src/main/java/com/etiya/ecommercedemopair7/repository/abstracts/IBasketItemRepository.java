package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBasketItemRepository extends JpaRepository<BasketItem, Integer> {
    List<BasketItem> findByBasketId(int basketId);
}
