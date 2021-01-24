package com.demo.tennistournament.model;

import com.demo.tennistournament.model.enums.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Tournament {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "tournament")
    private Set<Match>  matches = new HashSet<>();

    @ManyToMany
    @JoinTable(name="TOURNAMENT_SPONSOR",
            joinColumns = @JoinColumn(name="TOURNAMENT_ID"),
            inverseJoinColumns = @JoinColumn(name="SPONSOR_ID"))
    private Set<Sponsor> sponsors = new HashSet<>();

    @Column
    private String city;

    @Column
    private BigDecimal budget;

    protected Tournament(){}

    public void addMatch(Match match){ this.matches.add(match);}

    public void removeMatch(Match match){ this.matches.remove(match);}

    public void addSponsor(Sponsor sponsor){ this.sponsors.add(sponsor); }

    public void removeSponsor(Sponsor sponsor){ this.sponsors.remove(sponsor); }

}
