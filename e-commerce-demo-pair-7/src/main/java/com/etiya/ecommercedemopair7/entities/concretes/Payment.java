package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
@PrimaryKeyJoinColumn(name = "id")
public class Payment extends Order {

    @Column(name = "is_verified")
    private boolean isVerified;

    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;
}
