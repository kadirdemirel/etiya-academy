package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.OrderItem;
import com.etiya.ecommercedemopair7.entities.dtos.OrderItemDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Integer> {

    @Query("Select new com.etiya.ecommercedemopair7.entities.dtos.OrderItemDto " +
            "(oi.id, p.name, sp.stock, sp.unitPrice,oi.quantity,oi.itemTotalPrice, o.totalPrice,o.orderNumber," +
            "o.orderDate,sp.description) from OrderItem oi" +
            " inner join oi.sellerProduct sp inner join sp.product p" +
            " inner join oi.order o")
    List<OrderItemDto> getOrderItemDto();
}
