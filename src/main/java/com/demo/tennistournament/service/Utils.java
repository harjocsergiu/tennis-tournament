package com.demo.tennistournament.service;

public class Utils {

    public static boolean isValidPassword(String password){
        boolean strongPassword = false;
        if(password.length()<6)
            return false;
        if(password.toLowerCase().equals(password) || password.toUpperCase().equals(password))
            return false;
        for(char ch: password.toCharArray()){
            if(Character.isDigit(ch)){
                strongPassword = true;
                break;
            }
        }
        return strongPassword;
    }
}
