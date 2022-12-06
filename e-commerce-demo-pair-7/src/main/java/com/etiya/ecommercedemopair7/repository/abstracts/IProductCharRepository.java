package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.ProductChar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCharRepository extends JpaRepository<ProductChar,Integer> {
}
