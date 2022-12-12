package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ISellerService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.request.sellers.AddSellerRequest;
import com.etiya.ecommercedemopair7.business.response.sellers.AddSellerResponse;
import com.etiya.ecommercedemopair7.business.response.sellers.GetSellerResponse;
import com.etiya.ecommercedemopair7.core.utilities.exceptions.BusinessException;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.Seller;
import com.etiya.ecommercedemopair7.repository.abstracts.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerManager implements ISellerService {

    private ISellerRepository sellerRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public SellerManager(ISellerRepository sellerRepository, IModelMapperService modelMapperService) {
        this.sellerRepository = sellerRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<AddSellerResponse> add(AddSellerRequest addSellerRequest) {
        Seller seller = modelMapperService.forRequest().map(addSellerRequest, Seller.class);
        Seller savedSeller = sellerRepository.save(seller);

        AddSellerResponse response = modelMapperService.forResponse().map(savedSeller, AddSellerResponse.class);
        return new SuccessDataResult<>(response, Messages.Seller.sellerAdded);

    }

    @Override
    public DataResult<GetSellerResponse> getById(int sellerId) {
        Seller seller = existsBySellerId(sellerId);
        GetSellerResponse response = modelMapperService.forResponse().map(seller, GetSellerResponse.class);
        return new SuccessDataResult<>(response, Messages.Seller.sellerReceived);
    }

    @Override
    public Seller getBySellerId(int sellerId) {
        return existsBySellerId(sellerId);
    }

    private Seller existsBySellerId(int sellerId) {
        Seller currentSeller;
        try {
            currentSeller = this.sellerRepository.findById(sellerId).get();
        } catch (Exception e) {
            throw new BusinessException(Messages.Seller.sellerNotFound);
        }
        return currentSeller;
    }
}
