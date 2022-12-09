package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.deliveryOptions.AddDeliveryOptionRequest;
import com.etiya.ecommercedemopair7.business.response.customers.GetAllCustomerResponse;
import com.etiya.ecommercedemopair7.business.response.deliveryOptions.AddDeliveryOptionResponse;
import com.etiya.ecommercedemopair7.business.response.deliveryOptions.GetAllDeliveryOptionResponse;
import com.etiya.ecommercedemopair7.business.response.deliveryOptions.GetDeliveryOptionResponse;
import com.etiya.ecommercedemopair7.entities.concretes.DeliveryOption;

import java.util.List;

public interface IDeliveryOptionService {
    GetDeliveryOptionResponse getById(int id);

    DeliveryOption getByDeliveryOptionId(int id);

    AddDeliveryOptionResponse add(AddDeliveryOptionRequest addDeliveryOptionRequest);

    List<GetAllDeliveryOptionResponse> getAll();
}
