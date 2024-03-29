package com.demo.tennistournament.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "courts")
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private Short capacity;

    @OneToMany(mappedBy = "court")
    private Set<Match> matches = new HashSet<>();

    public Court(){}

    public Court(Short id, String name, Short capacity) {
        super();
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public Court(String name, Short capacity) {
        super();
        this.name = name;
        this.capacity = capacity;
    }

    public void addMatch(Match match){
        this.matches.add(match);
    }

    public void removeMatch(Match match){
        this.matches.remove(match);
    }

    @Override
    public String toString() {
        return String.format("%nCourt{name=%s, capacity=%s}",name,capacity);

    }
}
