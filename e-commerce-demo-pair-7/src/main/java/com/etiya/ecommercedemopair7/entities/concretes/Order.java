package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "delivery_options_id")
    private DeliveryOption deliveryOption;

    @ManyToOne
    @JoinColumn(name = "order_address_id")
    private Address orderAddress;

    @ManyToOne
    @JoinColumn(name = "invoice_address_id")
    private Address invoiceAddress;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_date")
    private LocalDate orderDate;


    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Invoice invoice;


}
