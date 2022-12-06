package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IBasketService;
import com.etiya.ecommercedemopair7.business.request.baskets.AddBasketRequest;
import com.etiya.ecommercedemopair7.business.response.baskets.AddBasketResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Basket;
import com.etiya.ecommercedemopair7.repository.abstracts.IBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketManager implements IBasketService {
    private IBasketRepository basketRepository;

    @Autowired
    public BasketManager(IBasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }


    @Override
    public AddBasketResponse add(AddBasketRequest addBasketRequest) {
        Basket basket = new Basket();
        basket.setTotalPrice(addBasketRequest.getTotalPrice());
        basket.setShippingPrice(addBasketRequest.getShippingPrice());
        Basket savedBasket = basketRepository.save(basket);
        AddBasketResponse response = new AddBasketResponse(savedBasket.getId(), savedBasket.getTotalPrice(), savedBasket.getShippingPrice());
        return response;
    }
}

