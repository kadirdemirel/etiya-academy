package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.dtos.ProductDetailDto;

import java.util.List;

public interface IProductDetailService {
    DataResult<List<ProductDetailDto>> getProductDetail();
}
