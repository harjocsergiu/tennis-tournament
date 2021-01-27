package com.demo.tennistournament.service;

import com.demo.tennistournament.model.User;
import com.demo.tennistournament.model.enums.RegisterState;
import com.demo.tennistournament.model.enums.ResetPasswordResponse;
import com.demo.tennistournament.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterState registerUser(String email, String password, String firstName, String lastName) {
        if(userRepository.findFirstByEmail(email).isPresent()){
            return RegisterState.EMAIL_DUPLICATE;
        }
        User user = new User(email,password,firstName,lastName);
        userRepository.save(user);
        return RegisterState.REGISTERED;
    }

    @Override
    public ResetPasswordResponse resetPassword(String token, String password) {
        return null;
    }
}
