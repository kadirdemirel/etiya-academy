package com.etiya.ecommercedemopair7.business.response.sellers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSellerResponse {
    private String email;
    private String name;
    private String number;
    private boolean isVerified;
}
