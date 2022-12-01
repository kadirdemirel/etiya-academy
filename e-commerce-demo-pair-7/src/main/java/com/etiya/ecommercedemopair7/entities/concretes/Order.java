package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Inheritance(strategy = InheritanceType.JOINED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "delivery_options_id")
    private DeliveryOption deliveryOption;

    @ManyToOne
    @JoinColumn(name = "order_address_id")
    private Address orderAddress;

    @ManyToOne
    @JoinColumn(name = "invoice_address_id")
    private Address invoiceAddress;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
