package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IProductDetailService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.ProductDetail;
import com.etiya.ecommercedemopair7.entities.dtos.ProductDetailDto;
import com.etiya.ecommercedemopair7.repository.abstracts.IProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDetailManager implements IProductDetailService {
    private IProductDetailRepository productDetailRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    ProductDetailManager(IProductDetailRepository productDetailRepository, IModelMapperService modelMapperService) {
        this.productDetailRepository = productDetailRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<ProductDetailDto>> getProductDetail() {
        List<ProductDetail> productDetails = productDetailRepository.findAll();
        List<ProductDetailDto> response = productDetails.stream().map(productDetail -> modelMapperService.forResponse()
                .map(productDetail, ProductDetailDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response);
    }
}
