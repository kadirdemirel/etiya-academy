package com.etiya.ecommercedemopair7.business.response.countries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCountryResponse {
    private int id;
    private String name;
}
