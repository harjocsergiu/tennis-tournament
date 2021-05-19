package com.demo.tennistournament.service;

import com.demo.tennistournament.model.MatchDetailsPOJO;
import com.demo.tennistournament.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public List<MatchDetailsPOJO> retrieveMatches() {
        List<MatchDetailsPOJO> matchDetailsList = new LinkedList<>();
        matchRepository.findAll().forEach(match -> {
            MatchDetailsPOJO matchDetails = new MatchDetailsPOJO();
            matchDetails.setPlayer1Name(match.getFirstPlayer().getUser().getFirstName() + " " + match.getFirstPlayer().getUser().getLastName());
            matchDetails.setPlayer2Name(match.getSecondPlayer().getUser().getFirstName() + " " + match.getSecondPlayer().getUser().getLastName());
            matchDetails.setCourt(match.getCourt().getName());
            matchDetails.setPhase(match.getPhase().toString());
            matchDetails.setResult(match.getResult());
            matchDetails.setStartTime(match.getStartTime());
            matchDetailsList.add(matchDetails);
        });
        return matchDetailsList;
    }
}
