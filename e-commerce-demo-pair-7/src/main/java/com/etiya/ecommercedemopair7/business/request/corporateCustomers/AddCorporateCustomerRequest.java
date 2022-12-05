package com.etiya.ecommercedemopair7.business.request.corporateCustomers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCorporateCustomerRequest {
    private String email;
    private String password;
    private String number;
    private String name;
    private String taxNumber;
}
