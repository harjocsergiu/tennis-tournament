package com.demo.tennistournament.controller;

import com.demo.tennistournament.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;
}
