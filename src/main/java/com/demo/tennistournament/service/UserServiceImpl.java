package com.demo.tennistournament.service;

import com.demo.tennistournament.exception.ResourceNotFoundException;
import com.demo.tennistournament.model.Role;
import com.demo.tennistournament.model.User;
import com.demo.tennistournament.model.UserDetailsImpl;
import com.demo.tennistournament.utils.SignupUtil;
import com.demo.tennistournament.model.enums.RegisterState;
import com.demo.tennistournament.model.enums.ResetPasswordResponse;
import com.demo.tennistournament.payload.request.SignupRequest;
import com.demo.tennistournament.repository.RoleRepository;
import com.demo.tennistournament.repository.UserRepository;
import com.demo.tennistournament.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static com.demo.tennistournament.exception.ExceptionMessages.NO_REGISTERED_EMAIL;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public SignupUtil registerUser(final SignupRequest signupRequest) {
        if (!signupRequest.getPassword().equals(signupRequest.getRepeatPassword()))
            return new SignupUtil(RegisterState.PASSWORDS_DO_NOT_MATCH,null);

        if (userRepository.findFirstByEmail(signupRequest.getEmail()).isPresent())
            return new SignupUtil(RegisterState.EMAIL_DUPLICATE, null);

        if (!Utils.isValidPassword(signupRequest.getPassword()))
            return new SignupUtil(RegisterState.WEAK_PASSWORD, null);

        User user = new User(signupRequest.getEmail(), passwordEncoder.encode(signupRequest.getPassword()), signupRequest.getFirstName(), signupRequest.getLastName());

        Set<Role> roles = SignupUtil.retrieveRole(signupRequest,roleRepository);
        user.setRoles(roles);

        return new SignupUtil(RegisterState.REGISTERED, userRepository.save(user));
    }

    @Override
    public ResetPasswordResponse resetPassword(String token, String password) {
        return null;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findFirstByEmail(email).orElseThrow(() -> new ResourceNotFoundException(NO_REGISTERED_EMAIL));
        return UserDetailsImpl.build(user);
    }
}
