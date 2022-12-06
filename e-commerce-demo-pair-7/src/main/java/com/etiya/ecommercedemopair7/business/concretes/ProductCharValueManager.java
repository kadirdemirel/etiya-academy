package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IProductCharService;
import com.etiya.ecommercedemopair7.business.abstracts.IProductCharValueService;
import com.etiya.ecommercedemopair7.business.request.productCharValues.AddProductCharValueRequest;
import com.etiya.ecommercedemopair7.business.response.productCharValues.AddProductCharValueResponse;
import com.etiya.ecommercedemopair7.entities.concretes.ProductChar;
import com.etiya.ecommercedemopair7.entities.concretes.ProductCharValue;
import com.etiya.ecommercedemopair7.repository.abstracts.IProductCharValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCharValueManager implements IProductCharValueService {

    private IProductCharValueRepository productCharValueRepository;
    private IProductCharService productCharService;

    @Autowired
    ProductCharValueManager(IProductCharValueRepository  productCharValueRepository,  IProductCharService productCharService) {
        this.productCharValueRepository = productCharValueRepository;
        this.productCharService = productCharService;
    }

    @Override
    public AddProductCharValueResponse add(AddProductCharValueRequest addProductCharValueRequest){
        ProductCharValue productCharValue = new ProductCharValue();
        productCharValue.setName(addProductCharValueRequest.getName());

        ProductChar productChar = getProductChar(addProductCharValueRequest);
        productCharValue.setProductChar(productChar);

        ProductCharValue savedProductCharValue = productCharValueRepository.save((productCharValue));
        return new AddProductCharValueResponse(savedProductCharValue.getId(),savedProductCharValue.getName(),savedProductCharValue.getProductChar().getId());
    }

    private ProductChar getProductChar(AddProductCharValueRequest addProductCharValueRequest) {
        ProductChar productChar = productCharService.getById(addProductCharValueRequest.getProductCharId());
        return productChar;
    }

}
