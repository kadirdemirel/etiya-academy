package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Town;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITownRepository extends JpaRepository<Town, Integer> {
}
