package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "baskets")
@PrimaryKeyJoinColumn(name = "id")
public class Basket extends Customer {
    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "shipping_price")
    private double shippingPrice;

    @OneToMany(mappedBy = "basket")
    private List<BasketItem> basketItems;

}
