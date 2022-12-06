package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICategoryService;
import com.etiya.ecommercedemopair7.business.abstracts.IProductCategoryService;
import com.etiya.ecommercedemopair7.business.abstracts.IProductService;
import com.etiya.ecommercedemopair7.business.request.productCategories.AddProductCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.productCategories.AddProductCategoryResponse;
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

    @Autowired
    public ProductCategoryManager(IProductCategoryRepository productCategoryRepository, ICategoryService categoryService, IProductService productService) {
        this.productCategoryRepository = productCategoryRepository;
        this.productService = productService;
        this.categoryService = categoryService;
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
        ProductCategory productCategory = new ProductCategory();
        Category category = existsByCategory(addProductCategoryRequest);
        Product product = existsByProduct(addProductCategoryRequest);
        productCategory.setCategory(category);
        productCategory.setProduct(product);

        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return new AddProductCategoryResponse(savedProductCategory.getId(), savedProductCategory.getCategory().getId(), savedProductCategory.getProduct().getId());
    }

    private Product existsByProduct(AddProductCategoryRequest addProductCategoryRequest) {
        Product product = productService.getById(addProductCategoryRequest.getProductId());
        return product;
    }

    private Category existsByCategory(AddProductCategoryRequest addProductCategoryRequest) {
        Category category = categoryService.getById(addProductCategoryRequest.getCategoryId());
        return category;
    }
}
