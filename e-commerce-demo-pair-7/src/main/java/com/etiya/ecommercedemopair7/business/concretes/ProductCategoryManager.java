package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICategoryService;
import com.etiya.ecommercedemopair7.business.abstracts.IProductCategoryService;
import com.etiya.ecommercedemopair7.business.abstracts.IProductService;
import com.etiya.ecommercedemopair7.business.request.productCategories.AddProductCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.productCategories.AddProductCategoryResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.Category;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;
import com.etiya.ecommercedemopair7.repository.abstracts.IProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryManager implements IProductCategoryService {

    private IProductCategoryRepository productCategoryRepository;
    private ICategoryService categoryService;
    private IProductService productService;
    private IModelMapperService modelMapperService;

    @Autowired
    public ProductCategoryManager(IProductCategoryRepository productCategoryRepository, ICategoryService categoryService, IProductService productService, IModelMapperService modelMapperService) {
        this.productCategoryRepository = productCategoryRepository;
        this.productService = productService;
        this.categoryService = categoryService;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public ProductCategory getByCategoryId(int categoryId) {
        return this.productCategoryRepository.findByCategoryId(categoryId);
    }

    @Override
    public ProductCategory getByProductId(int productId) {
        return this.productCategoryRepository.findByProductId(productId);
    }

    @Override
    public AddProductCategoryResponse add(AddProductCategoryRequest addProductCategoryRequest) {
        existsByCategory(addProductCategoryRequest);
        existsByProduct(addProductCategoryRequest);
        ProductCategory productCategory = modelMapperService.forRequest().map(addProductCategoryRequest, ProductCategory.class);

        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        AddProductCategoryResponse response = modelMapperService.forResponse().map(savedProductCategory, AddProductCategoryResponse.class);
        return response;
    }

    private Product existsByProduct(AddProductCategoryRequest addProductCategoryRequest) {
        Product product = productService.getByProductId(addProductCategoryRequest.getProductId());
        return product;
    }

    private Category existsByCategory(AddProductCategoryRequest addProductCategoryRequest) {
        Category category = categoryService.getByCategoryId(addProductCategoryRequest.getCategoryId());
        return category;
    }
}
