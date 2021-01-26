package com.demo.tennistournament.controller;

import com.demo.tennistournament.exception.ResourceNotFoundException;
import com.demo.tennistournament.model.Ticket;
import com.demo.tennistournament.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static com.demo.tennistournament.exception.ExceptionMessages.TICKET_NOT_FOUND;

@RestController
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping(path = "/api/tickets")
    public List<Ticket> retrieveAllTickets(){
        return ticketRepository.findAll();
    }

    @GetMapping(path="/api/tickets/{id}")
    public Ticket retrieveTicket(@PathVariable Long id){
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if(ticket.isEmpty())
            throw new ResourceNotFoundException(TICKET_NOT_FOUND);
        return ticket.get();
    }

    @PostMapping(path="/api/tickets")
    public ResponseEntity<Object> createTicket(@RequestBody Ticket ticket){
        Ticket savedTicket = ticketRepository.save(ticket);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTicket.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path= "/api/tickets/{id}")
    public ResponseEntity<Object> deleteTicket(@PathVariable Long id){
        ticketRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
