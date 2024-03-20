package com.astroitsolutions.inventorysystemapi.services;

import org.springframework.stereotype.Service;

import com.astroitsolutions.inventorysystemapi.entities.User;
import com.astroitsolutions.inventorysystemapi.respositories.UserRepository;
import com.astroitsolutions.inventorysystemapi.services.util.AuthRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private ObjectMapper mapper = new ObjectMapper();

    public AuthenticationService(UserRepository repository){
        this.userRepository = repository;
    }

    public User verifyUsername(String authData) throws JsonProcessingException{

        AuthRequest request = mapper.readValue(authData, AuthRequest.class);

        User user = userRepository.findByUsername(request.getUsername());

        return user;
    }
    
}
