package com.demo.tennistournament.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Court {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Byte id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private Short capacity;

    @OneToMany(mappedBy = "court")
    private Set<Match> matches = new HashSet<>();

    protected Court(){}
}
