package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    ProductCategory findByCategoryId(int categoryId);
    @Query("SELECT pc from ProductCategory as pc where pc.product.id=:productId")
    ProductCategory findByProductId(int productId);
}
