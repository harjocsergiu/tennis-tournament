package com.demo.tennistournament.controller;

import com.demo.tennistournament.model.Player;
import com.demo.tennistournament.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    public List<Player> retrieveAllPlayers(){
        return playerRepository.findAll();
    }

}
