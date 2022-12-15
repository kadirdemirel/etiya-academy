package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seller_products")
public class SellerProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "stock")
    private int stock;

    @Column(name = "unit_price")
    private double unitPrice;

    @OneToMany(mappedBy = "sellerProduct")
    private List<BasketItem> basketItems;

    @OneToMany(mappedBy = "sellerProduct")
    private List<OrderItem> orderItems;

}
