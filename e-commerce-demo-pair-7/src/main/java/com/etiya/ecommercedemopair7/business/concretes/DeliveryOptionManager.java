package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IDeliveryOptionService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.deliveryOptions.AddDeliveryOptionRequest;
import com.etiya.ecommercedemopair7.business.response.deliveryOptions.AddDeliveryOptionResponse;
import com.etiya.ecommercedemopair7.business.response.deliveryOptions.GetAllDeliveryOptionResponse;
import com.etiya.ecommercedemopair7.business.response.deliveryOptions.GetDeliveryOptionResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.DeliveryOption;
import com.etiya.ecommercedemopair7.repository.abstracts.IDeliveryOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryOptionManager implements IDeliveryOptionService {

    private IDeliveryOptionRepository deliveryOptionRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public DeliveryOptionManager(IDeliveryOptionRepository deliveryOptionRepository, IModelMapperService modelMapperService) {
        this.deliveryOptionRepository = deliveryOptionRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<GetDeliveryOptionResponse> getById(int id) {
        DeliveryOption deliveryOption = getDeliveryOption(id);
        GetDeliveryOptionResponse response = modelMapperService.forResponse().map(deliveryOption, GetDeliveryOptionResponse.class);
        return new SuccessDataResult<>(response, Messages.DeliveryOption.deliveryOptionReceived);
    }

    @Override
    public DeliveryOption getByDeliveryOptionId(int id) {
        return getDeliveryOption(id);
    }

    private DeliveryOption getDeliveryOption(int id) {
        DeliveryOption currentDeliveryOption;
        try {
            currentDeliveryOption = deliveryOptionRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException(Messages.DeliveryOption.deliveryOptionNotFound);
        }
        return currentDeliveryOption;
    }

    @Override
    public DataResult<AddDeliveryOptionResponse> add(AddDeliveryOptionRequest addDeliveryOptionRequest) {
        DeliveryOption deliveryOption = modelMapperService.forRequest().map(addDeliveryOptionRequest, DeliveryOption.class);
        DeliveryOption savedDeliveryOption = deliveryOptionRepository.save(deliveryOption);

        AddDeliveryOptionResponse response = modelMapperService.forResponse().map(savedDeliveryOption, AddDeliveryOptionResponse.class);
        return new SuccessDataResult<>(response, Messages.DeliveryOption.deliveryOptionAdded);
    }

    @Override
    public DataResult<List<GetAllDeliveryOptionResponse>> getAll() {
        List<DeliveryOption> deliveryOptions = this.deliveryOptionRepository.findAll();
        List<GetAllDeliveryOptionResponse> response = deliveryOptions.stream().map(deliveryOption -> this.modelMapperService.forResponse()
                .map(deliveryOption, GetAllDeliveryOptionResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response, Messages.DeliveryOption.deliveryOptionsListed);

    }
}
