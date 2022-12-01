package com.etiya.ecommercedemopair7.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoices")
@PrimaryKeyJoinColumn(name = "id")
public class Invoice extends Order {
    
    @Column(name = "number")
    private String number;

    @Column(name = "created_date")
    private LocalDate createdDate;
}

