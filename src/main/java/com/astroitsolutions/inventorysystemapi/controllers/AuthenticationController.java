package com.astroitsolutions.inventorysystemapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.astroitsolutions.inventorysystemapi.entities.User;
import com.astroitsolutions.inventorysystemapi.services.AuthenticationService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Service
@RestController
@Slf4j
public class AuthenticationController {

    private AuthenticationService authService;

    public AuthenticationController(AuthenticationService service){
        this.authService = service;
    }

    @PostMapping("/verify")
    public ResponseEntity<User> postMethodName(@RequestBody String authData) {
        User verifiedUser = null;
        HttpStatus status = null;
        try{
            verifiedUser = authService.verifyUsername(authData);
            if(verifiedUser != null){
                status = HttpStatus.OK;
            } else {
                status = HttpStatus.UNAUTHORIZED;
            }
        } catch(JsonProcessingException e){
            log.error("Error occurres processing Json: ", e);
            status = HttpStatus.BAD_REQUEST;
        } catch(Exception e){
            log.error("Internal Server Error: ", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        return ResponseEntity.status(status).body(verifiedUser);
    }
    
    
}
