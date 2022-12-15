package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IDistrictService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.response.districts.GetAllDistrictResponse;
import com.etiya.ecommercedemopair7.business.response.districts.GetDistrictResponse;
import com.etiya.ecommercedemopair7.core.utilities.exceptions.BusinessException;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.District;
import com.etiya.ecommercedemopair7.repository.abstracts.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictManager implements IDistrictService {

    private IDistrictRepository districtRepository;
    private IModelMapperService modelMapperService;
    private IMessageSourceService messageSourceService;

    @Autowired
    public DistrictManager(IDistrictRepository districtRepository, IModelMapperService modelMapperService,
                           IMessageSourceService messageSourceService) {
        this.districtRepository = districtRepository;
        this.modelMapperService = modelMapperService;
        this.messageSourceService = messageSourceService;
    }

    @Override
    public DataResult<GetDistrictResponse> getById(int districtId) {
        District district = checkIfDistrictExistsById(districtId);
        GetDistrictResponse response = modelMapperService.forResponse().map(district, GetDistrictResponse.class);
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.District.districtReceived));
    }

    @Override
    public DataResult<List<GetAllDistrictResponse>> getAll() {
        List<District> districts = this.districtRepository.findAll();
        List<GetAllDistrictResponse> response = districts.stream().map(district -> this.modelMapperService.forResponse()
                .map(district, GetAllDistrictResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.District.districtsListed));
    }

    private District checkIfDistrictExistsById(int id) {
        District currentDistrict;
        try {
            currentDistrict = this.districtRepository.findById(id).get();
        } catch (Exception e) {
            throw new BusinessException(messageSourceService.getMessage(Messages.District.districtNotFound));
        }
        return currentDistrict;
    }
}
