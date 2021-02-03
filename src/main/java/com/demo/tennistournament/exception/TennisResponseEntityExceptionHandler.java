package com.demo.tennistournament.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TennisResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
        return new ResponseEntity<>(exceptionResponse,exceptionResponse.getStatus());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse,exceptionResponse.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST,ex.getMessage()); // add more details
        return new ResponseEntity<>(exceptionResponse,exceptionResponse.getStatus());
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public final ResponseEntity<Object> handleResourceAlreadyExistsException(ResourceAlreadyExists ex){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse,exceptionResponse.getStatus());
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> handlePlacerHolderException(BadRequestException ex){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse,exceptionResponse.getStatus());
    }
}
