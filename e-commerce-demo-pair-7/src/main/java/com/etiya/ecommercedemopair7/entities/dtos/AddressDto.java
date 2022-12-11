package com.etiya.ecommercedemopair7.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private int id;
    private String title;
    private String address;
    private String streetName;
    private String districtName;
    private String townName;
    private String cityName;
    private String countryName;
    private String email;
}
