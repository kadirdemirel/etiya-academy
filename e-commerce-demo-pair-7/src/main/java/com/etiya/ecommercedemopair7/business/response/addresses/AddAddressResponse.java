package com.etiya.ecommercedemopair7.business.response.addresses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressResponse {
    private int id;
    private String title;
    private String address;
    private int userId;
    private int streetId;
}
