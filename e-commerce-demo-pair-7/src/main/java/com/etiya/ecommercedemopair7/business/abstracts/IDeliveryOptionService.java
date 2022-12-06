package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.deliveryOptions.AddDeliveryOptionRequest;
import com.etiya.ecommercedemopair7.business.response.deliveryOptions.AddDeliveryOptionResponse;
import com.etiya.ecommercedemopair7.entities.concretes.DeliveryOption;

public interface IDeliveryOptionService {
    DeliveryOption getById(int id);
    AddDeliveryOptionResponse add(AddDeliveryOptionRequest addDeliveryOptionRequest);
}
