package com.etiya.ecommercedemopair7.business.response.corporateCustomers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCorporateCustomerResponse {
    private String email;
    private String number;
    private String name;
    private String taxNumber;
}
