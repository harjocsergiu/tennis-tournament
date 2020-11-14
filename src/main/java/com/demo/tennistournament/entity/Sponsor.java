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
public class Sponsor {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column
    private String phoneContact;

    @Column
    private String emailContact;

    @ManyToMany(mappedBy = "sponsors")
    private Set<Tournament> tournaments = new HashSet<>();

    protected Sponsor(){}

}
