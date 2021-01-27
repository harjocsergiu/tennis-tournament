package com.demo.tennistournament.service;

import com.demo.tennistournament.model.UserRegisterUtil;
import com.demo.tennistournament.model.enums.RegisterState;
import com.demo.tennistournament.model.enums.ResetPasswordResponse;

public interface UserService {
    UserRegisterUtil registerUser(final String email, final String password,
                                  final String firstName, final String lastName);
    ResetPasswordResponse resetPassword(final String token, final String password);
}
