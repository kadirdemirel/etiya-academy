package com.etiya.ecommercedemopair7.business.request.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    @NotNull
    @Size(min = 3, max = 50)
    private String name;
}
