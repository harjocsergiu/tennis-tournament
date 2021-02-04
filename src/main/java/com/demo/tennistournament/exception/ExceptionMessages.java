package com.demo.tennistournament.exception;

public class ExceptionMessages {
    public static final String TICKET_NOT_FOUND = "Ticket not found.";
    public static final String EMAIL_REGISTERED = "This email is already registered.";
    public static final String INVALID_REQUEST_BODY = "Invalid request body format.";
    public static final String PASSWORDS_DO_NOT_MATCH_EXCEPTION = "Password and repeatPassword must match.";
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final String WEAK_PASSWORD_EXCEPTION = "Password must contain:"+
            "  At least 6 characters" +
            "  At least 1 capital letter" +
            "  At least 1 lowercase letter" +
            "  At least 1 digit";
}
