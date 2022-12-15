package com.etiya.ecommercedemopair7.entities.concretes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User {
    @OneToOne(mappedBy = "customer")
    @JsonManagedReference
    private Basket basket;

    @Column(name = "number")
    private String number;

    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;
}
