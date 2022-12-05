package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product getById(int productId);

    Product getByName(String name);

    Product customGetByName(String name);
}
