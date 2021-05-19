package com.demo.tennistournament.service;

import com.demo.tennistournament.model.MatchDetailsPOJO;

import java.util.List;

public interface MatchService {
    List<MatchDetailsPOJO> retrieveMatches();
}
