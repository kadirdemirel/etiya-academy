package com.etiya.ecommercedemopair7.business.request.sellers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSellerRequest {
    private String email;
    private String password;
    private String name;
    private String number;
    private boolean isVerified;

}
