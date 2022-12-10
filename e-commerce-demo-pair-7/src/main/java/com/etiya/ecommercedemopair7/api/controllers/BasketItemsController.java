package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IBasketItemService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.basketItems.AddBasketItemRequest;
import com.etiya.ecommercedemopair7.business.response.basketItems.AddBasketItemResponse;
import com.etiya.ecommercedemopair7.business.response.basketItems.GetAllBasketItemResponse;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "basket-items")
public class BasketItemsController {
    private IBasketItemService basketItemService;

    @Autowired
    public BasketItemsController(IBasketItemService basketItemService) {
        this.basketItemService = basketItemService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AddBasketItemRequest addBasketItemRequest) {
        return new ResponseEntity<>(basketItemService.add(addBasketItemRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public DataResult<List<GetAllBasketItemResponse>> getAll() {
        return basketItemService.getAll();
    }
}
