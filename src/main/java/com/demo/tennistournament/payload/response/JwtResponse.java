package com.demo.tennistournament.payload.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Long id;
    private String email;
    private String name;

    @Setter(AccessLevel.NONE)
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String email,String firstName, String lastName, List<String> roles) {
        this.accessToken = accessToken;
        this.id = id;
        this.email = email;
        this.name = firstName + " " + lastName;
        this.roles = roles;
    }

}