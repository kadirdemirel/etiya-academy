package com.etiya.ecommercedemopair7.business.request.addresses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {

    private String title;
    private String address;
    @Min(1)
    private int userId;
    @Min(1)
    private int streetId;
}
