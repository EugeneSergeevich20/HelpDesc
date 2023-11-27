package com.helpdesc.service;

import com.helpdesc.model.user.Client;
import com.helpdesc.model.user.Role;
import com.helpdesc.model.user.User;
import com.helpdesc.repositories.ClientRepository;
import com.helpdesc.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    public UserRegistrationService(UserRepository userRepository, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void register(Client client){
        client.setRole(Role.ROLE_CLIENT);
        client.setApplicationProblems(new ArrayList<>());
        clientRepository.save(client);
    }
}
