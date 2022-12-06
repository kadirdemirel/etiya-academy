package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "corporate_customers")
@PrimaryKeyJoinColumn(name = "id")
public class CorporateCustomer extends Customer {
    @Column(name = "name")
    private String name;

    @Column(name = "tax_number")
    private String taxNumber;
}
