package com.demo.tennistournament.model.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisterPOJO {
    private String email;
    private String password;
    private String repeatPassword;
    private String firstName;
    private String lastName;

    @JsonCreator
    public UserRegisterPOJO(@JsonProperty(value = "email", required = true) String email,
                            @JsonProperty(value = "password",required = true) String password,
                            @JsonProperty(value = "repeatPassword", required = true) String repeatPassword,
                            @JsonProperty(value = "firstName", required = true) String firstName,
                            @JsonProperty(value = "lastName", required = true) String lastName) {
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
