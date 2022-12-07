package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IBasketService;
import com.etiya.ecommercedemopair7.business.abstracts.ICustomerService;
import com.etiya.ecommercedemopair7.business.request.baskets.AddBasketRequest;
import com.etiya.ecommercedemopair7.business.response.baskets.AddBasketResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.Basket;
import com.etiya.ecommercedemopair7.repository.abstracts.IBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketManager implements IBasketService {
    private IBasketRepository basketRepository;
    private ICustomerService customerService;
    private IModelMapperService modelMapperService;

    @Autowired
    public BasketManager(IBasketRepository basketRepository, ICustomerService customerService,IModelMapperService modelMapperService) {
        this.basketRepository = basketRepository;
        this.customerService = customerService;
        this.modelMapperService=modelMapperService;
    }


    @Override
    public AddBasketResponse add(AddBasketRequest addBasketRequest) {
        Basket basket = modelMapperService.forRequest().map(addBasketRequest,Basket.class);
        Basket savedBasket = basketRepository.save(basket);
        AddBasketResponse response =modelMapperService.forResponse().map(savedBasket,AddBasketResponse.class);
        return response;
    }




}

