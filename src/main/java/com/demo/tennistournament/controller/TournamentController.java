package com.demo.tennistournament.controller;

import com.demo.tennistournament.model.Tournament;
import com.demo.tennistournament.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TournamentController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping("api/tournaments")
    public List<Tournament> retrieveAllTournaments(){ return tournamentRepository.findAll(); }

}
