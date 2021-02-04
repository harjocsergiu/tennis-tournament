package com.demo.tennistournament.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class UserRegisterRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatPassword;

    @NotBlank
    @Pattern(regexp = "^[^0-9]+$", message = "A name should not contain any digits.")
    @Size(min = 2, message = "First name should have at least 2 characters.")
    private String firstName;

    @NotBlank
    @Pattern(regexp = "^[^0-9]+$", message = "A name should not contain any digits.")
    @Size(min = 2, message = "Last name should have at least 2 characters.")
    private String lastName;

    public UserRegisterRequest(String email,String password,String repeatPassword, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }


//    @JsonCreator
//    public UserRegisterRequest(@JsonProperty(value = "email", required = true) String email,
//                            @JsonProperty(value = "password",required = true) String password,
//                            @JsonProperty(value = "repeatPassword", required = true) String repeatPassword,
//                            @JsonProperty(value = "firstName", required = true) String firstName,
//                            @JsonProperty(value = "lastName", required = true) String lastName) {
//        this.email = email;
//        this.password = password;
//        this.repeatPassword = repeatPassword;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
}
