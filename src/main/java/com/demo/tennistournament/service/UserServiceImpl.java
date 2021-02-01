package com.demo.tennistournament.service;

import com.demo.tennistournament.exception.PlacerHolderException;
import com.demo.tennistournament.model.User;
import com.demo.tennistournament.model.UserRegisterUtil;
import com.demo.tennistournament.model.enums.RegisterState;
import com.demo.tennistournament.model.enums.ResetPasswordResponse;
import com.demo.tennistournament.model.pojos.UserRegisterPOJO;
import com.demo.tennistournament.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRegisterUtil registerUser(UserRegisterPOJO userRegisterPOJO) {
        if (!userRegisterPOJO.getPassword().equals(userRegisterPOJO.getRepeatPassword()))
            return new UserRegisterUtil(RegisterState.PASSWORDS_DO_NOT_MATCH,null);

        if (userRepository.findFirstByEmail(userRegisterPOJO.getEmail()).isPresent())
            return new UserRegisterUtil(RegisterState.EMAIL_DUPLICATE, null);

        if (!Utils.isValidPassword(userRegisterPOJO.getPassword()))
            return new UserRegisterUtil(RegisterState.WEAK_PASSWORD, null);

        User user = new User(userRegisterPOJO.getEmail(), userRegisterPOJO.getPassword(), userRegisterPOJO.getFirstName(), userRegisterPOJO.getLastName());
        return new UserRegisterUtil(RegisterState.REGISTERED, userRepository.save(user));
    }

    @Override
    public ResetPasswordResponse resetPassword(String token, String password) {
        return null;
    }
}
