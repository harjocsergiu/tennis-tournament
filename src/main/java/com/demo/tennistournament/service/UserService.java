package com.demo.tennistournament.service;

import com.demo.tennistournament.exception.ResourceNotFoundException;
import com.demo.tennistournament.utils.SignupUtil;
import com.demo.tennistournament.model.enums.ResetPasswordResponse;
import com.demo.tennistournament.payload.request.SignupRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    SignupUtil registerUser(final SignupRequest signupRequest);
    ResetPasswordResponse resetPassword(final String token, final String password);
    UserDetails loadUserByUsername(String email) throws ResourceNotFoundException;
}
