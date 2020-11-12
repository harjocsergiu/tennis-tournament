package com.demo.tennistournament.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Player extends User {
    @Id
    @GeneratedValue
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

    protected Player(){ }

}
