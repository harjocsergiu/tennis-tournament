package com.demo.tennistournament.controller;

import com.demo.tennistournament.model.Player;
import com.demo.tennistournament.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/api/players")
    public List<Player> retrieveAllPlayers(){
        return playerRepository.findAll();
    }

    @GetMapping("/api/players/{id}")
    public Player retrievePlayer(@PathVariable Long id){
        Optional<Player> player = playerRepository.findById(id);
        if(player.isEmpty())
            throw new RuntimeException("Player not found");
        return player.get();
    }

}
