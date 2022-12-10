package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IProductService;
import com.etiya.ecommercedemopair7.business.abstracts.ISellerProductService;
import com.etiya.ecommercedemopair7.business.abstracts.ISellerService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.sellerProducts.AddSellerProductRequest;
import com.etiya.ecommercedemopair7.business.response.sellerProducts.AddSellerProductResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
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
    private IModelMapperService modelMapperService;

    @Autowired
    SellerProductManager(ISellerProductRepository sellerProductRepository, IProductService productService, ISellerService sellerService, IModelMapperService modelMapperService) {
        this.sellerProductRepository = sellerProductRepository;
        this.productService = productService;
        this.sellerService = sellerService;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public DataResult<AddSellerProductResponse> add(AddSellerProductRequest addSellerProductRequest) {
        existsByProduct(addSellerProductRequest.getProductId());
        existsBySeller(addSellerProductRequest.getSellerId());
        SellerProduct sellerProduct = modelMapperService.forRequest().map(addSellerProductRequest, SellerProduct.class);

        SellerProduct sellerProductSave = sellerProductRepository.save(sellerProduct);
        AddSellerProductResponse response = modelMapperService.forResponse().map(sellerProductSave, AddSellerProductResponse.class);
        return new SuccessDataResult<>(response, Messages.SellerProduct.sellerProductAdded);

    }

    private Product existsByProduct(int productId) {
        Product product = productService.getByProductId(productId);
        return product;
    }

    private Seller existsBySeller(int sellerId) {
        Seller seller = sellerService.getBySellerId(sellerId);
        return seller;
    }
}
