//package com.demo.tennistournament.soap.endpoints;
//
//import com.demo.tennistournament.model.Court;
//import com.demo.tennistournament.soap.exception.CourtNotFoundException;
//import com.demo.tennistournament.service.CourtService;
//import com.tennis_tournament.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
//import java.util.List;
//
//@Endpoint
//public class CourtEndpoint {
//
//    @Autowired
//    CourtService service;
//
//    //method
//    //input - Request
//    //output - Response
//    @PayloadRoot(namespace = "http://tennis-tournament.com/", localPart = "GetCourtDetailsRequest")
//    @ResponsePayload
//    public GetCourtDetailsResponse processCourtDetailsRequest(@RequestPayload GetCourtDetailsRequest request) {
//        Court court = service.findByName(request.getName());
//        if(court==null)
//            throw new CourtNotFoundException("No Court with the name " + request.getName());
//        return mapCourtDetails(court);
//    }
//
//    @PayloadRoot(namespace = "http://tennis-tournament.com/", localPart = "GetAllCourtDetailsRequest")
//    @ResponsePayload
//    public GetAllCourtDetailsResponse processAllCourtDetailsRequest(@RequestPayload GetAllCourtDetailsRequest request) {
//        List<Court> courts = service.findAll();
//        return mapAllCourtDetails(courts);
//    }
//
//    @PayloadRoot(namespace = "http://tennis-tournament.com/", localPart = "DeleteCourtDetailsRequest")
//    @ResponsePayload
//    public DeleteCourtDetailsResponse deleteCourtDetailsRequest(@RequestPayload DeleteCourtDetailsRequest request) {
//        CourtService.Status status = service.deleteByName(request.getName());
//        DeleteCourtDetailsResponse response = new DeleteCourtDetailsResponse();
//        response.setStatus(mapStatus(status));
//        return response;
//    }
//
//    private com.tennis_tournament.Status mapStatus(CourtService.Status status) {
//        if(status== CourtService.Status.FAILURE)
//            return com.tennis_tournament.Status.FAILURE;
//        return com.tennis_tournament.Status.SUCCESS;
//    }
//
//    private GetCourtDetailsResponse mapCourtDetails(Court court) {
//        GetCourtDetailsResponse response = new GetCourtDetailsResponse();
//        response.setCourtDetails(mapCourt(court));
//        return response;
//    }
//
//    private GetAllCourtDetailsResponse mapAllCourtDetails(List<Court> courts) {
//        GetAllCourtDetailsResponse response = new GetAllCourtDetailsResponse();
//        for(Court court: courts){
//            CourtDetails mapCourt = mapCourt(court);
//            response.getCourtDetails().add(mapCourt);
//        }
//        return response;
//    }
//
//    private CourtDetails mapCourt(Court court){
//        CourtDetails courtDetails = new CourtDetails();
//        courtDetails.setName(court.getName());
//        courtDetails.setCapacity(court.getCapacity());
//        return courtDetails;
//    }
//
//}
