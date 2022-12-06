package com.etiya.ecommercedemopair7.business.request.sellerProducts;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSellerProductRequest {
    private int sellerId;
    private int productId;
    private String description;
    private String imageUrl;
    @Min(value = 0,message = "Stok adedi en az 0 olmalıdır.")
    private int stock;
    @Min(value = 1,message = "Ücret alanı en az 1 olmalıdır")
    private double unitPrice;
}
