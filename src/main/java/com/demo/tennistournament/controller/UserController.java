package com.demo.tennistournament.controller;

import com.demo.tennistournament.model.User;
import com.demo.tennistournament.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }
}
