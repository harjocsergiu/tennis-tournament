package com.demo.tennistournament.controller;

import com.demo.tennistournament.model.Match;
import com.demo.tennistournament.model.MatchDetailsPOJO;
import com.demo.tennistournament.model.Player;
import com.demo.tennistournament.repository.MatchRepository;
import com.demo.tennistournament.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchService matchService;

    @GetMapping("/api/matches")
    public List<MatchDetailsPOJO> retrieveAllPlayers(){
        return  matchService.retrieveMatches();
    }
}
