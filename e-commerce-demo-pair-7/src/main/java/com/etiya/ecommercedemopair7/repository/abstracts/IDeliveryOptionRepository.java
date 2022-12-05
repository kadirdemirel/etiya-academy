package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.DeliveryOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeliveryOptionRepository extends JpaRepository<DeliveryOption,Integer> {
}
