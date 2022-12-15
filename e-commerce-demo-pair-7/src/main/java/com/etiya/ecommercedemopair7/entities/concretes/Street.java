package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "streets")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @OneToMany(mappedBy = "street")
    private List<Address> addresses;
}
