package com.demo.tennistournament.controller;

import com.demo.tennistournament.exception.InvalidRequestBodyFormatException;
import com.demo.tennistournament.exception.PlacerHolderException;
import com.demo.tennistournament.exception.ResourceAlreadyExists;
import com.demo.tennistournament.model.UserRegisterUtil;
import com.demo.tennistournament.model.enums.RegisterState;
import com.demo.tennistournament.model.pojos.UserRegisterPOJO;
import com.demo.tennistournament.service.UserService;
import com.demo.tennistournament.service.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

import static com.demo.tennistournament.exception.ExceptionMessages.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/api/user/register")
    public ResponseEntity<Object> register(@RequestBody String json){
        final ObjectMapper objectMapper = new ObjectMapper();
        UserRegisterPOJO userRegisterPOJO = null;
        try{
            userRegisterPOJO = objectMapper.readValue(json,UserRegisterPOJO.class);
            System.out.println(userRegisterPOJO);
        }catch(IOException ex){
//            throw new InvalidRequestBodyFormatException(INVALID_REQUEST_BODY + "SHOULD ADD MORE SPECIFIC DETAILS");
            throw new InvalidRequestBodyFormatException(ex.getMessage());
        }
        if(!userRegisterPOJO.getPassword().equals(userRegisterPOJO.getRepeatPassword())){
            throw new PlacerHolderException(PASSWORDS_DO_NOT_MATCH);
        }

        if(!Utils.isValidPassword(userRegisterPOJO.getPassword())){
             throw new PlacerHolderException(WEAK_PASSWORD);
        }
        UserRegisterUtil userRegisterUtil = userService.registerUser(userRegisterPOJO.getEmail(),userRegisterPOJO.getPassword(),
                                                               userRegisterPOJO.getFirstName(),userRegisterPOJO.getLastName());
        switch (userRegisterUtil.getRegisterState()){
            case EMAIL_DUPLICATE:
                throw new ResourceAlreadyExists(EMAIL_REGISTERED);
            case REGISTERED:
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(userRegisterUtil.getUser().getId())
                        .toUri();
                return ResponseEntity.created(location).build();

        }
        return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
