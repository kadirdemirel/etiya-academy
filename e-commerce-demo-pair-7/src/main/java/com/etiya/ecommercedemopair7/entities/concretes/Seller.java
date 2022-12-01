package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sellers")
@PrimaryKeyJoinColumn(name = "id")
public class Seller extends User {

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "is_verified")
    private boolean isVerified;

    @OneToMany(mappedBy = "seller")
    private List<SellerProduct> sellerProducts;
}
