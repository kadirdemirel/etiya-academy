package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;
import com.etiya.ecommercedemopair7.repository.abstracts.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryManager implements ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryManager(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public ProductCategory getByCategoryId(int categoryId) {
        return this.productCategoryRepository.findByCategoryId(categoryId);
    }

    @Override
    public ProductCategory getByProductId(int productId) {
        return this.productCategoryRepository.findByProductId(productId);
    }
}
