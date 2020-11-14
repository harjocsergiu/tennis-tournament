package com.demo.tennistournament.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Player extends User {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @OneToMany(mappedBy = "firstPlayer")
    private Set<Match> matches1 = new HashSet<>();

    @OneToMany(mappedBy = "secondPlayer")
    private Set<Match> matches2 = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private PrimaryHand primaryHand;

    @Column(unique = true)
    private int ranking;

    @Column(nullable = false)
    private int age;

    @Column
    private String nationality;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private BigDecimal careerEarnings;

    @ManyToMany(mappedBy = "players")
    private Set<Sponsor> sponsors = new HashSet<>();

    public void addSponsor(Sponsor sponsor){ this.sponsors.add(sponsor); }

    public void removeSponsor(Sponsor sponsor){ this.sponsors.remove(sponsor); }

    protected Player(){ }

}
