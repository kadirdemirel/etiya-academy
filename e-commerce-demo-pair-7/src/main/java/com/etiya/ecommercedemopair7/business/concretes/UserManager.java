package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IUserService;
import com.etiya.ecommercedemopair7.business.response.users.GetUserResponse;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.entities.concretes.User;
import com.etiya.ecommercedemopair7.repository.abstracts.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements IUserService {
    private IUserRepository userRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    UserManager(IUserRepository userRepository,IModelMapperService modelMapperService) {
        this.userRepository = userRepository;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public GetUserResponse getById(int id) {
        User user= checkIfUserExistsById(id);
        GetUserResponse response=modelMapperService.forResponse().map(user,GetUserResponse.class);
        return response;
    }

    @Override
    public User getByUserId(int id) {
        return checkIfUserExistsById(id);
    }

    private User checkIfUserExistsById(int id) {
        User currentUser = this.userRepository.findById(id).orElseThrow();
        return currentUser;
    }
}
