package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IProductCharService;
import com.etiya.ecommercedemopair7.business.request.productChars.AddProductCharRequest;
import com.etiya.ecommercedemopair7.business.response.productChars.AddProductCharResponse;
import com.etiya.ecommercedemopair7.entities.concretes.ProductChar;
import com.etiya.ecommercedemopair7.repository.abstracts.IProductCharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCharManager implements IProductCharService {
    private IProductCharRepository productCharRepository;

    @Autowired
    public ProductCharManager(IProductCharRepository productcharRepository){
        this.productCharRepository = productcharRepository;
    }

    @Override
    public ProductChar getById(int productCharId) {
        return productCharRepository.findById(productCharId).orElseThrow();
    }

    @Override
    public AddProductCharResponse add(AddProductCharRequest addProductCharRequest) {
        ProductChar productChar = new ProductChar();
        productChar.setName(addProductCharRequest.getName());

        ProductChar savedProductChar = productCharRepository.save((productChar));
        return  new AddProductCharResponse(savedProductChar.getId(),savedProductChar.getName(),
                savedProductChar.getDescription());
    }
}
