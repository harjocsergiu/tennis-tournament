package com.demo.tennistournament.controller;

import com.demo.tennistournament.exception.BadRequestException;
import com.demo.tennistournament.exception.ResourceAlreadyExists;
import com.demo.tennistournament.model.User;
import com.demo.tennistournament.model.UserDetailsImpl;
import com.demo.tennistournament.payload.response.MessageResponse;
import com.demo.tennistournament.utils.SignupUtil;
import com.demo.tennistournament.payload.request.SignupRequest;
import com.demo.tennistournament.payload.request.LoginRequest;
import com.demo.tennistournament.payload.response.JwtResponse;
import com.demo.tennistournament.security.jwt.JwtUtils;
import com.demo.tennistournament.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static com.demo.tennistournament.exception.ExceptionMessages.*;
import static com.demo.tennistournament.exception.SuccessMessages.ACCOUNT_SUCCESSFULLY_CREATED;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    @PostMapping("/api/login")
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,
                                                userDetails.getId(),
                                                userDetails.getEmail(),
                                                userDetails.getFirstName(),
                                                userDetails.getLastName(),
                                                roles));
    }

    @PostMapping("api/register")
    public ResponseEntity<Object> register(@Valid @RequestBody SignupRequest signupRequest) {

        SignupUtil signupUtil = userService.registerUser(signupRequest);
        switch (signupUtil.getRegisterState()) {
            case PASSWORDS_DO_NOT_MATCH:
                throw new BadRequestException(PASSWORDS_DO_NOT_MATCH_EXCEPTION);
            case EMAIL_DUPLICATE:
                throw new ResourceAlreadyExists(EMAIL_REGISTERED);
            case WEAK_PASSWORD:
                throw new BadRequestException(WEAK_PASSWORD_EXCEPTION);
            case REGISTERED:
                URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(signupUtil.getUser().getId())
                        .toUri();
                return ResponseEntity.created(location).body(ACCOUNT_SUCCESSFULLY_CREATED);
        }
        return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
