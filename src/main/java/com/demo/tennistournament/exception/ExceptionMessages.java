package com.demo.tennistournament.exception;

public class ExceptionMessages {
    public static final String TICKET_NOT_FOUND = "Ticket not found.";
    public static final String PLAYER_NOT_FOUND = "Player not found.";
    public static final String ROLE_NOT_FOUND = "Role is not found.";
    public static final String EMAIL_REGISTERED = "This email is already registered.";
    public static final String PASSWORDS_DO_NOT_MATCH_EXCEPTION = "Password does not match.";
    public static final String WEAK_PASSWORD_EXCEPTION = "Password must contain at least 6 characters, 1 capital letter, 1 lowercase letter and 1 digit";
    public static final String INVALID_JSON_IN_REQUEST_BODY = "Invalid JSON in request body";
    public static final String NO_REGISTERED_EMAIL = "This email is not registered.";


    public static final class FieldValidation{
        public static final String NO_DIGITS = "should not contain any digits.";
        public static final String MIN_2_CHARS = "should have at least 2 characters.";
        public static final String VALIDATION_ERROR = "Validation error.";
    }

}
