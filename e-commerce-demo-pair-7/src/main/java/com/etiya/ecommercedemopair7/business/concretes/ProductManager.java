package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IProductService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.products.AddProductRequest;
import com.etiya.ecommercedemopair7.business.response.products.AddProductResponse;
import com.etiya.ecommercedemopair7.business.response.products.GetAllProductResponse;
import com.etiya.ecommercedemopair7.business.response.products.GetProductResponse;
import com.etiya.ecommercedemopair7.core.utilities.exceptions.BusinessException;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import com.etiya.ecommercedemopair7.repository.abstracts.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements IProductService {

    private IProductRepository productRepository;
    private IModelMapperService modelMapperService;
    private IMessageSourceService messageSourceService;

    @Autowired
    ProductManager(IProductRepository productRepository,
                   IModelMapperService modelMapperService, IMessageSourceService messageSourceService) {
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
        this.messageSourceService = messageSourceService;
    }

    @Override
    public DataResult<List<GetAllProductResponse>> getAll() {

        List<Product> products = this.productRepository.findAll();
        List<GetAllProductResponse> response = products.stream()
                .map(product -> this.modelMapperService.forResponse().map(product, GetAllProductResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Product.productsListed));
    }

    @Override
    public DataResult<GetProductResponse> getById(int productId) {
        Product product = existsByProductId(productId);
        GetProductResponse response = modelMapperService.forResponse().map(product, GetProductResponse.class);
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Product.productReceived));
    }

    @Override
    public Product getByProductId(int productId) {
        return existsByProductId(productId);
    }

    @Override
    public DataResult<Product> getByName(String name) {
        return new SuccessDataResult<>(productRepository.findByName(name),
                messageSourceService.getMessage(Messages.Product.productReceived));
    }

    @Override
    public DataResult<Product> customGetByName(String name) {
        return new SuccessDataResult<>(productRepository.customFindByName(name),
                messageSourceService.getMessage(Messages.Product.productReceived));

    }

    @Override
    public DataResult<AddProductResponse> add(AddProductRequest addProductRequest) {
        Product product = modelMapperService.forRequest().map(addProductRequest, Product.class);
        Product savedProduct = productRepository.save(product);
        AddProductResponse response = modelMapperService.forResponse().map(savedProduct, AddProductResponse.class);
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Product.productAdded));
    }

    @Override
    public Page<GetAllProductResponse> getAllProductResponse(Pageable pageable) {
        return productRepository.getAllProductResponse(pageable);
    }

    private Product existsByProductId(int productId) {
        Product currentProduct;
        try {
            currentProduct = this.productRepository.findById(productId);
        } catch (Exception e) {
            throw new BusinessException(messageSourceService.getMessage(Messages.Product.productNotFound));
        }
        return currentProduct;
    }
}
