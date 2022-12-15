package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.business.response.products.GetAllProductResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import com.etiya.ecommercedemopair7.entities.dtos.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);

    @Query("SELECT p from Product as p where p.name=:name")
    Product customFindByName(String name);

    Product findById(int productId);

    @Query("Select new com.etiya.ecommercedemopair7.business.response.products.GetAllProductResponse (p.id,p.name) from Product p")
    Page<GetAllProductResponse> getAllProductResponse(Pageable pageable);
}
