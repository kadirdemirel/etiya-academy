package com.etiya.ecommercedemopair7.repository.abstracts;

import com.etiya.ecommercedemopair7.entities.concretes.ProductDetail;
import com.etiya.ecommercedemopair7.entities.dtos.ProductDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
    @Query("Select new com.etiya.ecommercedemopair7.entities.dtos.ProductDetailDto (pd.id,p.name,pc.name,pc.description,pcv.name) from ProductDetail pd inner join pd.productChar pc  inner join pd.product p inner join pd.productChar.productCharValues pcv")
    List<ProductDetailDto> getProductDetail();
}
