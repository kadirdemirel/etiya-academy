package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;
import com.etiya.ecommercedemopair7.entities.dtos.ProductCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    ProductCategory findByCategoryId(int categoryId);

    @Query("SELECT pc from ProductCategory as pc where pc.product.id=:productId")
    ProductCategory findByProductId(int productId);

    @Query("Select new com.etiya.ecommercedemopair7.entities.dtos.ProductCategoryDto (p.id,pc.name, c.name,c.refId)" +
            " From  ProductCategory p INNER JOIN p.product pc INNER JOIN p.category c")
    List<ProductCategoryDto> getProductCategoryDto();
}
