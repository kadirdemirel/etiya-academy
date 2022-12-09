package com.etiya.ecommercedemopair7.business.response.streets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllStreetResponse {
    private int id;
    private String name;
    private int districtId;
}
