package com.demo.tennistournament.controller;

import com.demo.tennistournament.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SponsorController {

    @Autowired
    private SponsorRepository sponsorRepository;
}
