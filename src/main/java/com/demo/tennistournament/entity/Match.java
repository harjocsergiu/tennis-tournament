package com.demo.tennistournament.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Match {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "first_player_id")
    private Player firstPlayer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "second_player_id")
    private Player secondPlayer;

    @Embedded
    private Result result;

    @Enumerated(EnumType.STRING)
    private Phase phase;

    @Column
    private LocalDateTime startTime;

    @Column
    private String court;

    protected Match() { }

}
