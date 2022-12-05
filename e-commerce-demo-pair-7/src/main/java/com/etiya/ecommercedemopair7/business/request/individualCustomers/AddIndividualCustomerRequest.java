package com.etiya.ecommercedemopair7.business.request.individualCustomers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddIndividualCustomerRequest {
    private String email;
    private String password;
    private String number;
    private String firstName;
    private String lastName;
    private String identity;
    private LocalDate birthDate;

}
