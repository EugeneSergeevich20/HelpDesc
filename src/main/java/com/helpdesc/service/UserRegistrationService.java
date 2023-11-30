package com.helpdesc.service;

import com.helpdesc.model.user.Client;
import com.helpdesc.model.user.Role;
import com.helpdesc.repositories.ClientRepository;
import com.helpdesc.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;

    public UserRegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void register(Client client){
        client.setRole(Role.ROLE_CLIENT);
        client.setApplicationProblems(new ArrayList<>());
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
    }
}
