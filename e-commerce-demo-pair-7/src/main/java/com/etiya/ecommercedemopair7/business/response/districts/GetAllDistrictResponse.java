package com.etiya.ecommercedemopair7.business.response.districts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDistrictResponse {
    private int id;
    private String name;
    private int townId;
}
