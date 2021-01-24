package com.demo.tennistournament.controller;

import com.demo.tennistournament.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;
}
