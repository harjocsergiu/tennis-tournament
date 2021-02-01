package com.demo.tennistournament.service;

import com.demo.tennistournament.model.UserRegisterUtil;
import com.demo.tennistournament.model.enums.RegisterState;
import com.demo.tennistournament.model.enums.ResetPasswordResponse;
import com.demo.tennistournament.model.pojos.UserRegisterPOJO;

public interface UserService {
    UserRegisterUtil registerUser(final UserRegisterPOJO userRegisterPOJO);
    ResetPasswordResponse resetPassword(final String token, final String password);
}
