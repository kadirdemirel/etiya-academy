package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStreetRepository extends JpaRepository<Street, Integer> {
}
