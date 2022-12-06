package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IBasketItemService;
import com.etiya.ecommercedemopair7.business.request.basketItems.AddBasketItemRequest;
import com.etiya.ecommercedemopair7.business.response.basketItems.AddBasketItemResponse;
import com.etiya.ecommercedemopair7.entities.concretes.BasketItem;
import com.etiya.ecommercedemopair7.repository.abstracts.IBasketItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketItemManager implements IBasketItemService {
    private IBasketItemRepository basketItemRepository;

    @Autowired
    public BasketItemManager(IBasketItemRepository basketItemRepository) {
        this.basketItemRepository = basketItemRepository;
    }

    @Override
    public AddBasketItemResponse add(AddBasketItemRequest addBasketItemRequest) {
        BasketItem basketItem = new BasketItem();
        basketItem.setQuantity(addBasketItemRequest.getQuantity());
        basketItem.setItemTotalPrice(addBasketItemRequest.getItemTotalPrice());
        BasketItem savedBasketItem = basketItemRepository.save(basketItem);
        return new AddBasketItemResponse(savedBasketItem.getId(), savedBasketItem.getBasket().getId(), savedBasketItem.getProduct().getId(), savedBasketItem.getQuantity(), savedBasketItem.getItemTotalPrice());

    }
}
