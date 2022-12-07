package com.etiya.ecommercedemopair7.business.response.cities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCityResponse {
    private int id;
    private String name;
    private int countryId;
}
