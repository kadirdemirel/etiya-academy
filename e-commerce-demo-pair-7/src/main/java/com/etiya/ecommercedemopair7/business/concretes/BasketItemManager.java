package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IBasketItemService;
import com.etiya.ecommercedemopair7.business.abstracts.IBasketService;
import com.etiya.ecommercedemopair7.business.abstracts.ISellerProductService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.basketItems.AddBasketItemRequest;
import com.etiya.ecommercedemopair7.business.request.baskets.UpdateBasketRequest;
import com.etiya.ecommercedemopair7.business.response.basketItems.AddBasketItemResponse;
import com.etiya.ecommercedemopair7.business.response.basketItems.GetAllBasketItemResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Basket;
import com.etiya.ecommercedemopair7.entities.concretes.BasketItem;
import com.etiya.ecommercedemopair7.entities.concretes.SellerProduct;
import com.etiya.ecommercedemopair7.repository.abstracts.IBasketItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketItemManager implements IBasketItemService {
    private IBasketItemRepository basketItemRepository;
    private IModelMapperService modelMapperService;
    private ISellerProductService sellerProductService;
    private IBasketService basketService;


    @Autowired
    public BasketItemManager(IBasketItemRepository basketItemRepository, IModelMapperService modelMapperService,
                             ISellerProductService sellerProductService, IBasketService basketService) {
        this.basketItemRepository = basketItemRepository;
        this.modelMapperService = modelMapperService;
        this.sellerProductService = sellerProductService;
        this.basketService = basketService;
    }

    @Transactional
    @Override
    public DataResult<AddBasketItemResponse> add(AddBasketItemRequest addBasketItemRequest) {
        //TODO:İlgili müşterinin sepeti var mı yok mu kontrol et
        //TODO:Ödeme yapıldıktan sonra ilgili müşterinin sepeti boşaltılmalı

        SellerProduct sellerProduct = sellerProductService.getBySellerProductId(addBasketItemRequest.getSellerProductId());

        BasketItem basketItem = modelMapperService.forRequest().map(addBasketItemRequest, BasketItem.class);
        basketItem.setItemTotalPrice(addBasketItemRequest.getQuantity() * sellerProduct.getUnitPrice());
        BasketItem savedBasketItem = basketItemRepository.save(basketItem);

        UpdateBasketRequest updateBasketRequest = updateBasketRequest(addBasketItemRequest, savedBasketItem);
        Basket basket = getBasket(updateBasketRequest);
        basketService.update(updateBasketRequest, basket);

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

    @Override
    public List<BasketItem> getByBasketItem(int basketId) {
        return basketItemRepository.findByBasketId(basketId);
    }

    private Basket getBasket(UpdateBasketRequest updateBasketRequest) {
        Basket basket = new Basket();
        basket.setId(updateBasketRequest.getId());
        basket.setShippingPrice(10);
        double resultTotalPrice = sumBasketTotalPrice(basket.getId());
        basket.setTotalPrice(resultTotalPrice + 10);
        return basket;
    }

    private UpdateBasketRequest updateBasketRequest(AddBasketItemRequest addBasketItemRequest, BasketItem savedBasketItem) {
        UpdateBasketRequest updateBasketRequest = new UpdateBasketRequest();
        updateBasketRequest.setId(addBasketItemRequest.getBasketId());
        updateBasketRequest.setCustomerId(savedBasketItem.getBasket().getCustomer().getId());
        return updateBasketRequest;
    }

    private double sumBasketTotalPrice(int id) {
        double result = 0;
        for (BasketItem basketItem : this.basketItemRepository
                .findByBasketId(id)) {

            result += basketItem.getItemTotalPrice();
        }
        return result;
    }

}
