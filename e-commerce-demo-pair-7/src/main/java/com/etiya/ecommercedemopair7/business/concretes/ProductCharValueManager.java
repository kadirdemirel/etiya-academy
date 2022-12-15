package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IProductCharService;
import com.etiya.ecommercedemopair7.business.abstracts.IProductCharValueService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.productCharValues.AddProductCharValueRequest;
import com.etiya.ecommercedemopair7.business.response.productCharValues.AddProductCharValueResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.ProductChar;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCharValue;
import com.etiya.ecommercedemopair7.repository.abstracts.IProductCharValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCharValueManager implements IProductCharValueService {

    private IProductCharValueRepository productCharValueRepository;
    private IProductCharService productCharService;
    private IModelMapperService modelMapperService;
    private IMessageSourceService messageSourceService;

    @Autowired
    ProductCharValueManager(IProductCharValueRepository productCharValueRepository,
                            IProductCharService productCharService, IModelMapperService modelMapperService,
                            IMessageSourceService messageSourceService) {
        this.productCharValueRepository = productCharValueRepository;
        this.productCharService = productCharService;
        this.modelMapperService = modelMapperService;
        this.messageSourceService = messageSourceService;
    }

    @Override
    public DataResult<AddProductCharValueResponse> add(AddProductCharValueRequest addProductCharValueRequest) {
        getProductChar(addProductCharValueRequest);
        ProductCharValue productCharValue = modelMapperService.forRequest()
                .map(addProductCharValueRequest, ProductCharValue.class);

        ProductCharValue savedProductCharValue = productCharValueRepository.save((productCharValue));
        AddProductCharValueResponse response = modelMapperService.forResponse()
                .map(savedProductCharValue, AddProductCharValueResponse.class);
        return new SuccessDataResult<>(response,
                messageSourceService.getMessage(Messages.ProductCharValue.productCharValueAdded));
    }

    private ProductChar getProductChar(AddProductCharValueRequest addProductCharValueRequest) {
        ProductChar productChar = productCharService.getByProductCharId(addProductCharValueRequest.getProductCharId());
        return productChar;
    }

}
