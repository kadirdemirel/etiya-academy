package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IUserService;
import com.etiya.ecommercedemopair7.business.constants.Messages;
import com.etiya.ecommercedemopair7.business.response.users.GetAllUserResponse;
import com.etiya.ecommercedemopair7.business.response.users.GetUserResponse;
import com.etiya.ecommercedemopair7.core.utilities.exceptions.BusinessException;
import com.etiya.ecommercedemopair7.core.utilities.mapping.IModelMapperService;
import com.etiya.ecommercedemopair7.core.utilities.messages.IMessageSourceService;
import com.etiya.ecommercedemopair7.core.utilities.results.DataResult;
import com.etiya.ecommercedemopair7.core.utilities.results.SuccessDataResult;
import com.etiya.ecommercedemopair7.entities.concretes.User;
import com.etiya.ecommercedemopair7.repository.abstracts.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements IUserService {
    private IUserRepository userRepository;
    private IModelMapperService modelMapperService;
    private IMessageSourceService messageSourceService;

    @Autowired
    UserManager(IUserRepository userRepository, IModelMapperService modelMapperService) {
        this.userRepository = userRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<GetAllUserResponse>> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> response = users.stream()
                .map(user -> modelMapperService.forResponse().map(user, GetAllUserResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.User.usersListed));
    }

    @Override
    public DataResult<GetUserResponse> getById(int id) {
        User user = checkIfUserExistsById(id);
        GetUserResponse response = modelMapperService.forResponse().map(user, GetUserResponse.class);
        return new SuccessDataResult<>(response, messageSourceService.getMessage(Messages.User.userReceived));
    }

    @Override
    public User getByUserId(int id) {
        return checkIfUserExistsById(id);
    }

    private User checkIfUserExistsById(int id) {
        User currentUser;
        try {
            currentUser = this.userRepository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new BusinessException(messageSourceService.getMessage(Messages.User.userNotFound));
        }
        return currentUser;
    }
}
