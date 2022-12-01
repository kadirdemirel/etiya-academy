package com.etiya.ecommercedemopair7.entities.concretes;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "delivery_options")
public class DeliveryOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column (name = "name")
    private String name;

    @OneToMany(mappedBy = "deliveryOption")
    private List<Order> orders;
}
