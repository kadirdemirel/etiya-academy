package com.etiya.ecommercedemopair7.api.controllers;

import com.etiya.ecommercedemopair7.business.abstracts.IBasketService;
import com.etiya.ecommercedemopair7.business.constants.Paths;
import com.etiya.ecommercedemopair7.business.request.baskets.AddBasketRequest;
import com.etiya.ecommercedemopair7.business.response.baskets.AddBasketResponse;
import com.etiya.ecommercedemopair7.business.response.baskets.GetAllBasketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "baskets")
public class BasketsController {
    private IBasketService basketService;

    @Autowired
    public BasketsController(IBasketService basketService){
        this.basketService = basketService;
    }

    @GetMapping("/getall")
    public List<GetAllBasketResponse> getAll(){
        return this.basketService.getAll();
    }
    @PostMapping("/add")
    public ResponseEntity<AddBasketResponse> add (@RequestBody AddBasketRequest addBasketRequest){
        return new ResponseEntity<AddBasketResponse>(basketService.add(addBasketRequest), HttpStatus.CREATED);
    }
}
