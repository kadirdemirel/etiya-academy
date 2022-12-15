package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.*;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.orderItems.AddOrderItemRequest;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.Result;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessResult;
import com.etiya.ecommercedemopair7.entities.concretes.Basket;
import com.etiya.ecommercedemopair7.entities.concretes.BasketItem;
import com.etiya.ecommercedemopair7.entities.concretes.OrderItem;
import com.etiya.ecommercedemopair7.entities.dtos.OrderItemDto;
import com.etiya.ecommercedemopair7.repository.abstracts.IOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemManager implements IOrderItemService {
    private IOrderItemRepository orderItemRepository;
    private IModelMapperService modelMapperService;

    private ISellerProductService sellerProductService;
    private IBasketItemService basketItemService;
    private IBasketService basketService;
    private IMessageSourceService messageSourceService;

    @Autowired
    public OrderItemManager(IOrderItemRepository orderItemRepository, IModelMapperService modelMapperService,
                            ISellerProductService sellerProductService,
                            IBasketItemService basketItemService, IBasketService basketService, IMessageSourceService messageSourceService) {
        this.orderItemRepository = orderItemRepository;
        this.modelMapperService = modelMapperService;
        this.sellerProductService = sellerProductService;
        this.basketItemService = basketItemService;
        this.basketService = basketService;
        this.messageSourceService = messageSourceService;
    }

    @Override
    public DataResult<List<OrderItemDto>> getOrderItemDto() {
        List<OrderItem> orderItems = this.orderItemRepository.findAll();
        List<OrderItemDto> response = orderItems.stream().map(orderItem -> modelMapperService.forResponse()
                .map(orderItem, OrderItemDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.OrderItem.orderItemsListed));
    }

    @Transactional
    @Override
    public Result add(AddOrderItemRequest addOrderItemRequest) {
        Basket basket = basketService.getByCustomerId(addOrderItemRequest.getCustomerId());
        List<BasketItem> basketItems = basketItemService.getByBasketItem(basket.getId());
        savedOrderItem(addOrderItemRequest, basketItems);
        return new SuccessResult(messageSourceService.getMessage(Messages.OrderItem.orderItemAdded));
    }

    private void savedOrderItem(AddOrderItemRequest addOrderItemRequest, List<BasketItem> basketItems) {
        for (BasketItem basketItem : basketItems) {
            addOrderItemRequest.setItemTotalPrice(basketItem.getItemTotalPrice());
            addOrderItemRequest.setQuantity(basketItem.getQuantity());
            addOrderItemRequest.setSellerProductId(basketItem.getSellerProduct().getId());
            OrderItem orderItem = modelMapperService.forRequest().map(addOrderItemRequest, OrderItem.class);
            orderItemRepository.save(orderItem);
        }
    }

}
