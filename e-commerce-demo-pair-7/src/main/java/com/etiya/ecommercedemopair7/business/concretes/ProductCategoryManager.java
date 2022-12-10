package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ICategoryService;
import com.etiya.ecommercedemopair7.business.abstracts.IProductCategoryService;
import com.etiya.ecommercedemopair7.business.abstracts.IProductService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.productCategories.AddProductCategoryRequest;
import com.etiya.ecommercedemopair7.business.response.orders.GetAllOrderResponse;
import com.etiya.ecommercedemopair7.business.response.productCategories.AddProductCategoryResponse;
import com.etiya.ecommercedemopair7.business.response.productCategories.GetAllProductCategoryResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Category;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCategory;
import com.etiya.ecommercedemopair7.repository.abstracts.IProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;

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
    public DataResult<ProductCategory> getByCategoryId(int categoryId) {
        return new SuccessDataResult<>(this.productCategoryRepository.findByCategoryId(categoryId), Messages.ProductCategory.productCategoryReceived);
    }

    @Override
    public DataResult<ProductCategory> getByProductId(int productId) {
        return new SuccessDataResult<>(this.productCategoryRepository.findByCategoryId(productId), Messages.ProductCategory.productCategoryReceived);
    }

    @Override
    public DataResult<AddProductCategoryResponse> add(AddProductCategoryRequest addProductCategoryRequest) {
        existsByCategory(addProductCategoryRequest);
        existsByProduct(addProductCategoryRequest);
        ProductCategory productCategory = modelMapperService.forRequest().map(addProductCategoryRequest, ProductCategory.class);

        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        AddProductCategoryResponse response = modelMapperService.forResponse().map(savedProductCategory, AddProductCategoryResponse.class);
        return new SuccessDataResult<>(response, Messages.ProductCategory.productCategoryAdded);
    }

    @Override
    public DataResult<List<GetAllProductCategoryResponse>> getAll() {
        List<ProductCategory> productCategories = this.productCategoryRepository.findAll();
        List<GetAllProductCategoryResponse> response = productCategories.stream().map(productCategory -> this.modelMapperService
                .forResponse().map(productCategory, GetAllProductCategoryResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response, Messages.ProductCategory.productCategoriesListed);
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
