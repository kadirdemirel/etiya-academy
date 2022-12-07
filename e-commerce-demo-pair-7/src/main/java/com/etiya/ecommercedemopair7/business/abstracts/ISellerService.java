package com.etiya.ecommercedemopair7.business.abstracts;


import com.etiya.ecommercedemopair7.business.request.sellers.AddSellerRequest;
import com.etiya.ecommercedemopair7.business.response.sellers.AddSellerResponse;
import com.etiya.ecommercedemopair7.business.response.sellers.GetSellerResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Seller;

public interface ISellerService {
    AddSellerResponse add(AddSellerRequest addSellerRequest);

    GetSellerResponse getById(int sellerId);
   Seller getBySellerId(int sellerId);
}
