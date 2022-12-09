package com.etiya.ecommercedemopair7.business.response.sellerProducts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSellerProductResponse {
    private int id;
    private int sellerId;
    private int productId;
    private String description;
    private String imageUrl;
    private int stock;
    private double unitPrice;
}
