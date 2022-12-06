package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IDeliveryOptionService;
import com.etiya.ecommercedemopair7.business.request.deliveryOptions.AddDeliveryOptionRequest;
import com.etiya.ecommercedemopair7.business.response.deliveryOptions.AddDeliveryOptionResponse;
import com.etiya.ecommercedemopair7.entities.concretes.DeliveryOption;
import com.etiya.ecommercedemopair7.repository.abstracts.IDeliveryOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryOptionManager implements IDeliveryOptionService {

    private IDeliveryOptionRepository deliveryOptionRepository;

    @Autowired
    public DeliveryOptionManager(IDeliveryOptionRepository deliveryOptionRepository) {
        this.deliveryOptionRepository = deliveryOptionRepository;
    }

    @Override
    public DeliveryOption getById(int id) {
        return deliveryOptionRepository.findById(id).orElseThrow();
    }

    @Override
    public AddDeliveryOptionResponse add(AddDeliveryOptionRequest addDeliveryOptionRequest) {
        DeliveryOption deliveryOption = new DeliveryOption();
        deliveryOption.setName(addDeliveryOptionRequest.getName());

        DeliveryOption savedDeliveryOption = deliveryOptionRepository.save(deliveryOption);


        return new AddDeliveryOptionResponse(savedDeliveryOption.getId(), savedDeliveryOption.getName());

    }
}
