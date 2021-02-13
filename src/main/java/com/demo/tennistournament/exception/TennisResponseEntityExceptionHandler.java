package com.demo.tennistournament.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.demo.tennistournament.exception.ExceptionMessages.*;
import static com.demo.tennistournament.exception.ExceptionMessages.FieldValidation.VALIDATION_ERROR;
import static com.demo.tennistournament.utils.Constants.SPACE;

@ControllerAdvice
public class TennisResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = createExceptionResponseMethodArgumentNotValid(ex);
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public final ResponseEntity<Object> handleResourceAlreadyExistsException(ResourceAlreadyExists ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
    }

    @ExceptionHandler({BadRequestException.class, InternalAuthenticationServiceException.class, BadCredentialsException.class})
    public final ResponseEntity<Object> handleBadRequestException(Exception ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, INVALID_JSON_IN_REQUEST_BODY);
        exceptionResponse.addErrorDetail(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
    }


    private ExceptionResponse createExceptionResponseMethodArgumentNotValid(MethodArgumentNotValidException ex){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, VALIDATION_ERROR);
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            StringBuilder exceptionMessage = new StringBuilder();
            exceptionMessage.append(fieldError.getField()).append(SPACE).append(fieldError.getDefaultMessage());
            exceptionResponse.addErrorDetail(exceptionMessage.toString());
        }
        return exceptionResponse;
    }
}
