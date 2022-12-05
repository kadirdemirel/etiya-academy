package com.etiya.ecommercedemopair7.business.abstracts;

import com.etiya.ecommercedemopair7.business.request.deliveryOptions.AddDeliveryOptionRequest;
import com.etiya.ecommercedemopair7.business.response.deliveryOptions.AddDeliveryOptionResponse;

public interface IDeliveryOptionService {
    AddDeliveryOptionResponse add(AddDeliveryOptionRequest addDeliveryOptionRequest);
}
