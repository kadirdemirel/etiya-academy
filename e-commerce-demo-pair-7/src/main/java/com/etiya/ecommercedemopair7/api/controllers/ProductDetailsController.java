package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IProductDetailService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.dtos.ProductDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "product-details")
public class ProductDetailsController {
    private IProductDetailService productDetailService;

    @Autowired
    ProductDetailsController(IProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @GetMapping("get-all-dto")
    public ResponseEntity<DataResult<List<ProductDetailDto>>> getProductDetail() {
        return ResponseEntity.ok(productDetailService.getProductDetail());
    }
}
