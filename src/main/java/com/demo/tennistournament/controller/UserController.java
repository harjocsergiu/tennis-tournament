package com.demo.tennistournament.controller;

import com.demo.tennistournament.exception.InvalidRequestBodyFormatException;
import com.demo.tennistournament.exception.PlacerHolderException;
import com.demo.tennistournament.exception.ResourceAlreadyExists;
import com.demo.tennistournament.model.enums.RegisterState;
import com.demo.tennistournament.model.pojos.UserRegisterPOJO;
import com.demo.tennistournament.service.UserService;
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
    public ResponseEntity register(@RequestBody String json){
        final ObjectMapper objectMapper = new ObjectMapper();
        UserRegisterPOJO userRegisterPOJO = null;
        try{
            userRegisterPOJO = objectMapper.readValue(json,UserRegisterPOJO.class);
        }catch(IOException ex){
//            throw new InvalidRequestBodyFormatException(INVALID_REQUEST_BODY);
            throw new InvalidRequestBodyFormatException(ex.getMessage());
        }
        if(!userRegisterPOJO.getPassword().equals(userRegisterPOJO.getRepeatPassword())){
            throw new InvalidRequestBodyFormatException(PASSWORDS_DO_NOT_MATCH);
        }

        RegisterState registerState = userService.registerUser(userRegisterPOJO.getEmail(),userRegisterPOJO.getPassword(),
                                                               userRegisterPOJO.getFirstName(),userRegisterPOJO.getLastName());
        switch (registerState){
            case EMAIL_DUPLICATE:
                throw new ResourceAlreadyExists(EMAIL_REGISTERED);
            case PASSOWRD_WEAK:
                throw new PlacerHolderException("Weak password. Get Stronger boyyyyy.");
            case REGISTERED:
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand("toImplement")
                        .toUri();
                return ResponseEntity.created(location).build();

        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
