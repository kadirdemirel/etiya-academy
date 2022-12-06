package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IProductService;
import com.etiya.ecommercedemopair7.business.abstracts.ISellerProductService;
import com.etiya.ecommercedemopair7.business.abstracts.ISellerService;
import com.etiya.ecommercedemopair7.business.request.productCategories.AddProductCategoryRequest;
import com.etiya.ecommercedemopair7.business.request.sellerProducts.AddSellerProductRequest;
import com.etiya.ecommercedemopair7.business.request.sellers.AddSellerRequest;
import com.etiya.ecommercedemopair7.business.response.sellerProducts.AddSellerProductResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import com.etiya.ecommercedemopair7.entities.concretes.Seller;
import com.etiya.ecommercedemopair7.entities.concretes.SellerProduct;
import com.etiya.ecommercedemopair7.repository.abstracts.ISellerProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerProductManager implements ISellerProductService {
    private ISellerProductRepository sellerProductRepository;
    private IProductService productService;
    private ISellerService sellerService;

    @Autowired
    SellerProductManager(ISellerProductRepository sellerProductRepository, IProductService productService, ISellerService sellerService) {
        this.sellerProductRepository = sellerProductRepository;
        this.productService = productService;
        this.sellerService = sellerService;
    }


    @Override
    public AddSellerProductResponse add(AddSellerProductRequest addSellerProductRequest) {
        SellerProduct sellerProduct = new SellerProduct();
        Product product = existsByProduct(addSellerProductRequest.getProductId());
        Seller seller = existsBySeller(addSellerProductRequest.getSellerId());
        sellerProduct.setSeller(seller);
        sellerProduct.setProduct(product);
        sellerProduct.setDescription(addSellerProductRequest.getDescription());
        sellerProduct.setStock(addSellerProductRequest.getStock());
        sellerProduct.setImageUrl(addSellerProductRequest.getImageUrl());
        sellerProduct.setUnitPrice(addSellerProductRequest.getUnitPrice());

        SellerProduct sellerProductSave = sellerProductRepository.save(sellerProduct);

        return new AddSellerProductResponse(sellerProductSave.getId(), sellerProductSave.getProduct().getId(), sellerProductSave.getSeller().getId(),
                sellerProductSave.getDescription(), sellerProductSave.getImageUrl(), sellerProductSave.getStock(), sellerProductSave.getUnitPrice());

    }

    private Product existsByProduct(int productId) {
        Product product = productService.getById(productId);
        return product;
    }

    private Seller existsBySeller(int sellerId) {
        Seller seller = sellerService.getById(sellerId);
        return seller;
    }
}
