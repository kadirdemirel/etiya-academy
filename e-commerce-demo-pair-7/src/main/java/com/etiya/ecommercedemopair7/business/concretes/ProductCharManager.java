package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IProductCharService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.productChars.AddProductCharRequest;
import com.etiya.ecommercedemopair7.business.response.productChars.AddProductCharResponse;
import com.etiya.ecommercedemopair7.business.response.productChars.GetProductCharResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.ProductChar;
import com.etiya.ecommercedemopair7.repository.abstracts.IProductCharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCharManager implements IProductCharService {
    private IProductCharRepository productCharRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public ProductCharManager(IProductCharRepository productcharRepository, IModelMapperService modelMapperService) {
        this.productCharRepository = productcharRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<GetProductCharResponse> getById(int productCharId) {
        ProductChar productChar = checkIfProductCharExistsById(productCharId);
        GetProductCharResponse response = modelMapperService.forResponse().map(productChar, GetProductCharResponse.class);
        return new SuccessDataResult<>(response,Messages.ProductChar.productCharReceived);
    }

    @Override
    public ProductChar getByProductCharId(int productCharId) {
        return checkIfProductCharExistsById(productCharId);
    }


    @Override
    public DataResult<AddProductCharResponse> add(AddProductCharRequest addProductCharRequest) {
        ProductChar productChar = modelMapperService.forRequest().map(addProductCharRequest, ProductChar.class);
        ProductChar savedProductChar = productCharRepository.save((productChar));
        AddProductCharResponse response = modelMapperService.forResponse().map(savedProductChar, AddProductCharResponse.class);
        return new SuccessDataResult<>(response,Messages.ProductChar.productCharAdded);
    }

    private ProductChar checkIfProductCharExistsById(int productCharId) {
        ProductChar currentProductChar;
        try {
            currentProductChar = productCharRepository.findById(productCharId).get();
        } catch (Exception e) {
            throw new RuntimeException(Messages.ProductChar.productCharNotFound);
        }
        return currentProductChar;
    }
}
