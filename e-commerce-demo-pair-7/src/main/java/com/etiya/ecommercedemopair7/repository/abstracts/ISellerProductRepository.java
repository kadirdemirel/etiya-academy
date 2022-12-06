package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.SellerProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISellerProductRepository extends JpaRepository<SellerProduct, Integer> {
}
