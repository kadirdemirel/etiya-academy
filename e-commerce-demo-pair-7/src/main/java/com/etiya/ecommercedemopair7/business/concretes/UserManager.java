package com.etiya.ecommercedemopair7.business.concretes;

import com.etiya.ecommercedemopair7.business.abstracts.IUserService;
import com.etiya.ecommercedemopair7.entities.concretes.User;
import com.etiya.ecommercedemopair7.repository.abstracts.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements IUserService {
    private IUserRepository userRepository;

    @Autowired
    UserManager(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(int id) {
        return checkIfUserExistsById(id);
    }

    private User checkIfUserExistsById(int id) {
        User currentUser = this.userRepository.findById(id).orElseThrow();
        return currentUser;
    }
}
