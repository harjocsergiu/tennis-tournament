package com.demo.tennistournament.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Match {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

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

    @ManyToOne
    @JoinColumn(name="court_id")
    private Court court;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @OneToMany(mappedBy = "match")
    private Set<Ticket> tickets = new HashSet<>();

    protected Match() { }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket){
        this.tickets.remove(ticket);
    }

}
