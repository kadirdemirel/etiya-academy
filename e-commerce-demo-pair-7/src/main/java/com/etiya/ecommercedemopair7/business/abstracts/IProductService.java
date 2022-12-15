package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.products.AddProductRequest;
import com.etiya.ecommercedemopair7.business.response.products.AddProductResponse;
import com.etiya.ecommercedemopair7.business.response.products.GetAllProductResponse;
import com.etiya.ecommercedemopair7.business.response.products.GetProductResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import com.etiya.ecommercedemopair7.entities.dtos.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    DataResult<List<GetAllProductResponse>> getAll();

    DataResult<GetProductResponse> getById(int productId);

    Product getByProductId(int productId);

    DataResult<Product> getByName(String name);

    DataResult<Product> customGetByName(String name);

    DataResult<AddProductResponse> add(AddProductRequest addProductRequest);
    Page<GetAllProductResponse> getAllProductResponse(Pageable pageable);
}
