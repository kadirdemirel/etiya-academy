package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Address;
import com.etiya.ecommercedemopair7.entities.dtos.AddressDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address, Integer> {
    @Query("Select new com.etiya.ecommercedemopair7.entities.dtos.AddressDto  (ad.id,ad.title,ad.address,a.name,d.name,t.name,ci.name,c.name)" +
            " From Address ad inner join ad.street a inner join a.district d inner join d.town t inner join t.city ci inner join ci.country c")
    List<AddressDto> getAddressDto();
}
