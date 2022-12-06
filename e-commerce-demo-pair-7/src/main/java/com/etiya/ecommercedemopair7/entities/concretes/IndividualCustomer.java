package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "individual_customers")
@PrimaryKeyJoinColumn(name = "id")
public class IndividualCustomer extends Customer {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity")
    private String identity;

    @Column(name = "birth_date")
    private LocalDate birthDate;
}
