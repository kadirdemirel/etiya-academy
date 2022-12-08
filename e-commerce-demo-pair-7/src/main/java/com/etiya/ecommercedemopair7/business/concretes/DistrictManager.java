package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IDistrictService;
import com.etiya.ecommercedemopair7.business.response.districts.GetDistrictResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.District;
import com.etiya.ecommercedemopair7.repository.abstracts.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictManager implements IDistrictService {

    private IDistrictRepository districtRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public DistrictManager(IDistrictRepository districtRepository, IModelMapperService modelMapperService) {
        this.districtRepository = districtRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public GetDistrictResponse getById(int districtId) {
        District district = checkIfDistrictExistsById(districtId);
        GetDistrictResponse response = modelMapperService.forResponse().map(district, GetDistrictResponse.class);
        return response;
    }

    private District checkIfDistrictExistsById(int id) {
        District currentDistrict = this.districtRepository.findById(id).orElseThrow();
        return currentDistrict;
    }
}