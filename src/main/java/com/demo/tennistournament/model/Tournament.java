package com.demo.tennistournament.model;

import com.demo.tennistournament.model.enums.Gender;
import com.demo.tennistournament.model.enums.Surface;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="tournaments")
public class Tournament {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;

//    @Enumerated(EnumType.STRING)
//    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Surface surface;

    @JsonIgnore
    @OneToMany(mappedBy = "tournament")
    private Set<Match>  matches = new HashSet<>(15);

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="TOURNAMENT_SPONSOR",
            joinColumns = @JoinColumn(name="TOURNAMENT_ID"),
            inverseJoinColumns = @JoinColumn(name="SPONSOR_ID"))
    private Set<Sponsor> sponsors = new HashSet<>();

    @Column
    private String city;

    @Column
    private Integer winnerPoints;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    protected Tournament(){}

    public Tournament(String name, Surface surface, String city, Integer winnerPoints, LocalDate startDate) {
        this.name = name;
        this.surface = surface;
        this.city = city;
        this.winnerPoints = winnerPoints;
        this.startDate = startDate;
        this.endDate = startDate.plusDays(3);
    }

    public Tournament(String name, Surface surface, String city, Integer winnerPoints, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.surface = surface;
        this.city = city;
        this.winnerPoints = winnerPoints;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addMatch(Match match){ this.matches.add(match);}

    public void removeMatch(Match match){ this.matches.remove(match);}

    public void addSponsor(Sponsor sponsor){ this.sponsors.add(sponsor); }

    public void removeSponsor(Sponsor sponsor){ this.sponsors.remove(sponsor); }

}
