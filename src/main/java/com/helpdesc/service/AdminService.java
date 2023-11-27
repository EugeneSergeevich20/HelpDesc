package com.helpdesc.service;

import com.helpdesc.model.user.User;
import com.helpdesc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;

    @Autowired
    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

}
