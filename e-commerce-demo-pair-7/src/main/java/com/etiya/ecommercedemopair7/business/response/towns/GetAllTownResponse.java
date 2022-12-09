package com.etiya.ecommercedemopair7.business.response.towns;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTownResponse {
    private int id;
    private String name;
    private int cityId;
}
