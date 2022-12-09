package com.etiya.ecommercedemopair7.business.request.cities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCityRequest {
    @NotNull
    private String name;

}
