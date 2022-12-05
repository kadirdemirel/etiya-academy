package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IProductCategoryService;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;
import com.etiya.ecommercedemopair7.repository.abstracts.IProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryManager implements IProductCategoryService {

    private IProductCategoryRepository IProductCategoryRepository;

    @Autowired
    public ProductCategoryManager(IProductCategoryRepository IProductCategoryRepository) {
        this.IProductCategoryRepository = IProductCategoryRepository;
    }

    @Override
    public ProductCategory getByCategoryId(int categoryId) {
        return this.IProductCategoryRepository.findByCategoryId(categoryId);
    }

    @Override
    public ProductCategory getByProductId(int productId) {
        return this.IProductCategoryRepository.findByProductId(productId);
    }
}
