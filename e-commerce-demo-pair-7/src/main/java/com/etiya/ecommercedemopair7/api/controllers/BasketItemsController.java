package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IBasketItemService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.basketItems.AddBasketItemRequest;
import com.etiya.ecommercedemopair7.business.response.basketItems.AddBasketItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "basket-items")
public class BasketItemsController {
    private IBasketItemService basketItemService;

    @Autowired
    public BasketItemsController(IBasketItemService basketItemService) {
        this.basketItemService = basketItemService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddBasketItemResponse> add(@RequestBody AddBasketItemRequest addBasketItemRequest) {
        return new ResponseEntity<AddBasketItemResponse>(basketItemService.add(addBasketItemRequest), HttpStatus.CREATED);
    }
}
