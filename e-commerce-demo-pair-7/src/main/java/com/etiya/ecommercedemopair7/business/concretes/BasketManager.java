package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IBasketService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.baskets.AddBasketRequest;
import com.etiya.ecommercedemopair7.business.request.baskets.UpdateBasketRequest;
import com.etiya.ecommercedemopair7.business.response.baskets.UpdateBasketResponse;
import com.etiya.ecommercedemopair7.business.response.baskets.GetAllBasketResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Basket;
import com.etiya.ecommercedemopair7.repository.abstracts.IBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketManager implements IBasketService {
    private IBasketRepository basketRepository;
    private IModelMapperService modelMapperService;
    private IMessageSourceService messageSourceService;
    ;

    @Autowired
    public BasketManager(IBasketRepository basketRepository, IModelMapperService modelMapperService,
                         IMessageSourceService messageSourceService) {
        this.basketRepository = basketRepository;
        this.modelMapperService = modelMapperService;
        this.messageSourceService = messageSourceService;

    }

    @Override
    public DataResult<List<GetAllBasketResponse>> getAll() {
        List<Basket> baskets = this.basketRepository.findAll();
        List<GetAllBasketResponse> response = baskets.stream().map(basket -> modelMapperService.forResponse().
                map(basket, GetAllBasketResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Basket.basketsListed));

    }

    @Transactional
    @Override
    public Basket createBasket(AddBasketRequest addBasketRequest) {
        Basket basket = modelMapperService.forRequest().map(addBasketRequest, Basket.class);
        Basket savedBasket = basketRepository.save(basket);
        return savedBasket;
    }

    @Transactional
    @Override
    public DataResult<UpdateBasketResponse> update(UpdateBasketRequest updateBasketRequest, Basket getBasket) {
        Basket basket = modelMapperService.forRequest().map(updateBasketRequest, Basket.class);
        basket.setId(getBasket.getId());
        basket.setShippingPrice(getBasket.getShippingPrice());
        basket.setTotalPrice(getBasket.getTotalPrice());

        Basket savedBasket = basketRepository.save(basket);

        UpdateBasketResponse response = modelMapperService.forResponse().map(savedBasket, UpdateBasketResponse.class);
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.Basket.basketAdded));
    }

    @Override
    public Basket getByCustomerId(int customerId) {
        return basketRepository.findByCustomerId(customerId);
    }
}

