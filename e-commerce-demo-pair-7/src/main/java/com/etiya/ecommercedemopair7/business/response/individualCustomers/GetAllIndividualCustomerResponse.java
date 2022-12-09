package com.etiya.ecommercedemopair7.business.response.individualCustomers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllIndividualCustomerResponse {
    private String email;
    private String number;
    private String firstName;
    private String lastName;
    private String identity;
    private LocalDate birthDate;
}
