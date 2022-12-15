package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    @OneToMany(mappedBy = "orderAddress")
    private List<Payment> orderAddresses;

    @OneToMany(mappedBy = "invoiceAddress")
    private List<Payment> invoiceAddresses;
}
