package com.demo.tennistournament.utils;

import com.demo.tennistournament.exception.ResourceNotFoundException;
import com.demo.tennistournament.model.ERole;
import com.demo.tennistournament.model.Role;
import com.demo.tennistournament.model.User;
import com.demo.tennistournament.model.enums.RegisterState;
import com.demo.tennistournament.payload.request.SignupRequest;
import com.demo.tennistournament.repository.RoleRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import static com.demo.tennistournament.exception.ExceptionMessages.ROLE_NOT_FOUND;

@Getter
@Setter
public class SignupUtil {
    private RegisterState registerState;
    private User user;

    public SignupUtil(RegisterState registerState, User user) {
        this.registerState = registerState;
        this.user = user;
    }

    public static Set<Role> retrieveRole(SignupRequest signupRequest, RoleRepository roleRepository){
        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new ResourceNotFoundException(ROLE_NOT_FOUND));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new ResourceNotFoundException(ROLE_NOT_FOUND));
                        roles.add(adminRole);

                        break;
                    case "player":
                        Role modRole = roleRepository.findByName(ERole.ROLE_PLAYER)
                                .orElseThrow(() -> new ResourceNotFoundException(ROLE_NOT_FOUND));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new ResourceNotFoundException(ROLE_NOT_FOUND));
                        roles.add(userRole);
                }
            });
        }
        return roles;
    }
}
