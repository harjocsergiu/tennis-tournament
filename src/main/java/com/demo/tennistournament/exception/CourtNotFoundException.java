package com.demo.tennistournament.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class CourtNotFoundException extends RuntimeException{
    public CourtNotFoundException(String message) {
        super(message);
    }
}
