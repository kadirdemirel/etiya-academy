package com.etiya.ecommercedemopair7.business.response.addresses;

import com.etiya.ecommercedemopair7.entities.concretes.Street;
import com.etiya.ecommercedemopair7.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAddressResponse {
    private int id;
    private String title;
    private String address;
    private User userId;
    private Street streetId;

}
