package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ISellerService;
import com.etiya.ecommercedemopair7.business.request.sellers.AddSellerRequest;
import com.etiya.ecommercedemopair7.business.response.sellers.AddSellerResponse;
import com.etiya.ecommercedemopair7.entities.concretes.Seller;
import com.etiya.ecommercedemopair7.repository.abstracts.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerManager implements ISellerService {

    private ISellerRepository sellerRepository;

    @Autowired
    public SellerManager(ISellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public AddSellerResponse add(AddSellerRequest addSellerRequest) {
        Seller seller = new Seller();
        seller.setEmail(addSellerRequest.getEmail());
        seller.setPassword(addSellerRequest.getPassword());
        seller.setName(addSellerRequest.getName());
        seller.setNumber(addSellerRequest.getNumber());
        seller.setVerified(addSellerRequest.isVerified());

        Seller savedSeller = sellerRepository.save(seller);

        AddSellerResponse response = new AddSellerResponse(savedSeller.getEmail(), savedSeller.getName(),
                savedSeller.getNumber(), savedSeller.isVerified());

        return response;


    }
}
