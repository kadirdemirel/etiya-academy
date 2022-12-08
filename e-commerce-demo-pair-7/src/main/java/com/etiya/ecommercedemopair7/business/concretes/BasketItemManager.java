package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IBasketItemService;
import com.etiya.ecommercedemopair7.business.request.basketItems.AddBasketItemRequest;
import com.etiya.ecommercedemopair7.business.response.basketItems.AddBasketItemResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.BasketItem;
import com.etiya.ecommercedemopair7.repository.abstracts.IBasketItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketItemManager implements IBasketItemService {
    private IBasketItemRepository basketItemRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public BasketItemManager(IBasketItemRepository basketItemRepository,IModelMapperService modelMapperService) {
        this.basketItemRepository = basketItemRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public AddBasketItemResponse add(AddBasketItemRequest addBasketItemRequest) {
        BasketItem basketItem = modelMapperService.forRequest().map(addBasketItemRequest, BasketItem.class);
        BasketItem savedBasketItem = basketItemRepository.save(basketItem);
        AddBasketItemResponse response = modelMapperService.forResponse().map(savedBasketItem, AddBasketItemResponse.class);
        return response;

    }
}