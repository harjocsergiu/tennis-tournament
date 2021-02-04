package com.demo.tennistournament.service;

import com.demo.tennistournament.model.UserRegisterUtil;
import com.demo.tennistournament.model.enums.ResetPasswordResponse;
import com.demo.tennistournament.model.UserRegisterRequest;

import javax.validation.Valid;

public interface UserService {
    UserRegisterUtil registerUser(final UserRegisterRequest userRegisterRequest);
    ResetPasswordResponse resetPassword(final String token, final String password);
}
