package com.helpdesc.service;

import com.helpdesc.model.user.User;
import com.helpdesc.repositories.UserRepository;
import com.helpdesc.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()){
            throw new UsernameNotFoundException("User not found!");
        }

        return new UserDetailsImpl(user.get());
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public User getAuthUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDerails;

        if (authentication instanceof AnonymousAuthenticationToken)
            return null;
        else
            userDerails = (UserDetailsImpl) authentication.getPrincipal();

        /*if (authentication.getPrincipal() == "anonymousUser")
            return null;
        else
            userDerails = (UserDetailsImpl) authentication.getPrincipal();*/
        return userDerails.getUser();
    }

}
