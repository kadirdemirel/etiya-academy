package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IBasketItemService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.basketItems.AddBasketItemRequest;
import com.etiya.ecommercedemopair7.business.response.basketItems.AddBasketItemResponse;
import com.etiya.ecommercedemopair7.business.response.basketItems.GetAllBasketItemResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.BasketItem;
import com.etiya.ecommercedemopair7.repository.abstracts.IBasketItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketItemManager implements IBasketItemService {
    private IBasketItemRepository basketItemRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public BasketItemManager(IBasketItemRepository basketItemRepository, IModelMapperService modelMapperService) {
        this.basketItemRepository = basketItemRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<AddBasketItemResponse>  add(AddBasketItemRequest addBasketItemRequest) {
        BasketItem basketItem = modelMapperService.forRequest().map(addBasketItemRequest, BasketItem.class);
        BasketItem savedBasketItem = basketItemRepository.save(basketItem);
        AddBasketItemResponse response = modelMapperService.forResponse().map(savedBasketItem, AddBasketItemResponse.class);
        return new SuccessDataResult<>(response);
    }

    @Override
    public DataResult<List<GetAllBasketItemResponse>> getAll() {
        List<BasketItem> basketItems = this.basketItemRepository.findAll();
        List<GetAllBasketItemResponse> response = basketItems.stream().map(basketItem -> this.modelMapperService
                .forResponse().map(basketItem, GetAllBasketItemResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response);
    }
}
