package com.demo.tennistournament.model.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterPOJO {
    private String email;
    private String password;
    private String repeatPassword;
    private String firstName;
    private String lastName;
}
