package com.etiya.ecommercedemopair7.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "shipping_price")
    private double shippingPrice;

    @OneToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "basket")
    private List<BasketItem> basketItems;

}
