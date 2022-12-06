package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IDistrictService;
import com.etiya.ecommercedemopair7.entities.concretes.District;
import com.etiya.ecommercedemopair7.repository.abstracts.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictManager implements IDistrictService {

    private IDistrictRepository districtRepository;

    @Autowired
    public DistrictManager(IDistrictRepository districtRepository){
        this.districtRepository = districtRepository;
    }

    @Override
    public District getById(int districtId) {
        return checkIfDistrictExistsById(districtId);
    }

    private District checkIfDistrictExistsById(int id) {
        District currentDistrict = this.districtRepository.findById(id).orElseThrow();
        return currentDistrict;
    }
}
