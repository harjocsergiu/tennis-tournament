package com.demo.tennistournament.soap.endpoints;

import com.demo.tennistournament.entity.Court;
import com.demo.tennistournament.service.CourtService;
import com.tennis_tournament.courts.CourtDetails;
import com.tennis_tournament.courts.GetCourtDetailsRequest;
import com.tennis_tournament.courts.GetCourtDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourtEndpoint {

    @Autowired
    CourtService service;

    //method
    //input - GetCourtDetailsRequest
    //output - GetCourtDetailsResponse
    @PayloadRoot(namespace = "http://tennis-tournament.com/courts", localPart = "GetCourtDetailsRequest")
    @ResponsePayload
    public GetCourtDetailsResponse processCourtDetailsRequest(@RequestPayload GetCourtDetailsRequest request) {
        Court court = service.findByName(request.getName());
        return mapCourt(court);
    }


    private GetCourtDetailsResponse mapCourt(Court court) {
        GetCourtDetailsResponse response = new GetCourtDetailsResponse();
        CourtDetails courtDetails = new CourtDetails();
        courtDetails.setName(court.getName());
        courtDetails.setCapacity(court.getCapacity());
        response.setCourtDetails(courtDetails);
        return response;
    }
}
