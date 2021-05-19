package com.demo.tennistournament.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MatchDetailsPOJO {

    private LocalDateTime startTime;
    private Result result;
    private String player1Name;
    private String player2Name;
    private String court;
    private String phase;
}
