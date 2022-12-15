package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {
}
