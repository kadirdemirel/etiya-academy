package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "item_total_price")
    private double itemTotalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "seller_product_id")
    private SellerProduct sellerProduct;
}
