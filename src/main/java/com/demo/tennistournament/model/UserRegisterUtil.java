package com.demo.tennistournament.model;

import com.demo.tennistournament.model.enums.RegisterState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterUtil {
    private RegisterState registerState;
    private User user;

    public UserRegisterUtil(RegisterState registerState, User user) {
        this.registerState = registerState;
        this.user = user;
    }
}
