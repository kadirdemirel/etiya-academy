package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.ITownService;
import com.etiya.ecommercedemopair7.entities.concretes.Town;
import com.etiya.ecommercedemopair7.repository.abstracts.ITownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TownManager implements ITownService {

    private ITownRepository townRepository;

    @Autowired
    public TownManager(ITownRepository townRepository){
        this.townRepository = townRepository;
    }

    @Override
    public Town getById(int townId) {
        return checkIfTownExistsById(townId);
    }

    private Town checkIfTownExistsById(int id) {
        Town currentTown = this.townRepository.findById(id).orElseThrow();
        return currentTown;
    }
}


