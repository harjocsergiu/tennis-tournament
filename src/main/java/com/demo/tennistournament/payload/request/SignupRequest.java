package com.demo.tennistournament.payload.request;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

import java.util.Set;

import static com.demo.tennistournament.exception.ExceptionMessages.FieldValidation.MIN_2_CHARS;
import static com.demo.tennistournament.exception.ExceptionMessages.FieldValidation.NO_DIGITS;
import static com.demo.tennistournament.utils.Constants.REGEXP_NO_DIGITS;

@Getter
@Setter
@ToString
public class SignupRequest {

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 40)
    private String password;

    private Set<String> role;

    @NotBlank
    @Size(max = 120)
    private String repeatPassword;

    @NotBlank
    @Pattern(regexp = REGEXP_NO_DIGITS, message = NO_DIGITS)
    @Size(min = 2, message = MIN_2_CHARS)
    private String firstName;

    @NotBlank
    @Pattern(regexp = REGEXP_NO_DIGITS, message = NO_DIGITS)
    @Size(min = 2, message = MIN_2_CHARS)
    private String lastName;

    public SignupRequest(String email, String password, String repeatPassword, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
