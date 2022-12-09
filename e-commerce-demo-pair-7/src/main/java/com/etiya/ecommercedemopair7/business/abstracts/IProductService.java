package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.products.AddProductRequest;
import com.etiya.ecommercedemopair7.business.response.products.AddProductResponse;
import com.etiya.ecommercedemopair7.business.response.products.GetAllProductResponse;
import com.etiya.ecommercedemopair7.business.response.products.GetProductResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Product;
import java.util.List;

public interface IProductService {
    List<GetAllProductResponse> getAll();

    GetProductResponse getById(int productId);
    Product getByProductId(int productId);

    Product getByName(String name);

    Product customGetByName(String name);

    AddProductResponse add(AddProductRequest addProductRequest);
}
