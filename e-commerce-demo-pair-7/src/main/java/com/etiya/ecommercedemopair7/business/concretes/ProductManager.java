package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IProductService;
import com.etiya.ecommercedemopair7.business.request.products.AddProductRequest;
import com.etiya.ecommercedemopair7.business.response.products.AddProductResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Category;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import com.etiya.ecommercedemopair7.repository.abstracts.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements IProductService {

    private IProductRepository productRepository;

    @Autowired
    ProductManager(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getById(int productId) {
        return existsByProductId(productId);
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product customGetByName(String name) {
        return productRepository.customFindByName(name);
    }

    @Override
    public AddProductResponse add(AddProductRequest addProductRequest) {
        Product product = new Product();
        product.setName(addProductRequest.getName());

        Product savedProduct = productRepository.save(product);

        return new AddProductResponse(savedProduct.getId(), savedProduct.getName());
    }

    private Product existsByProductId(int productId) {
        Product currentProduct;
        try {
            currentProduct = this.productRepository.findById(productId).get();
        } catch (Exception e) {
            throw new RuntimeException("İlgili ürün bulunamadı.");
        }
        return currentProduct;
    }
}
