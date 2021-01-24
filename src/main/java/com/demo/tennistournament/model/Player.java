package com.demo.tennistournament.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

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
    private byte age;

    @Column
    private String nationality;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private BigDecimal careerEarnings;

    @OneToMany(mappedBy = "player",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<PlayerSponsorContract> sponsors = new ArrayList<>();

    public void addSponsor(Sponsor sponsor){
        PlayerSponsorContract playerSponsorContract = new PlayerSponsorContract(this,sponsor);
        sponsors.add(playerSponsorContract);
        sponsor.getPlayers().add(playerSponsorContract);
    }

    public void removeSponsor(Sponsor sponsor){
        for(Iterator<PlayerSponsorContract> iterator = sponsors.iterator(); iterator.hasNext(); ){
            PlayerSponsorContract psContract = iterator.next();

            if(psContract.getPlayer().equals(this) && psContract.getSponsor().equals(sponsor)){
                iterator.remove();
                psContract.getSponsor().getPlayers().remove(psContract);
                psContract.setPlayer(null);
                psContract.setSponsor(null);
            }
        }
    }

    protected Player(){ }

}
