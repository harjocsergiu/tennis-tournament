package com.demo.tennistournament.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Match {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Player firstPlayer;

    @ManyToOne
    private Player secondPlayer;

    @Embedded
    private Result result;

    @Enumerated(EnumType.STRING)
    private Phase phase;

    @Column
    private LocalDateTime startTime;

    @Column
    private String court;

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public Integer getId() {
        return id;
    }
}
