package com.demo.tennistournament.model;

import com.demo.tennistournament.model.enums.Gender;
import com.demo.tennistournament.model.enums.PrimaryHand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@Entity
public class Player {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(name = "player_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "player_id")
    private User user;

    @OneToMany(mappedBy = "firstPlayer")
    private Set<Match> matches1 = new HashSet<>();

    @OneToMany(mappedBy = "secondPlayer")
    private Set<Match> matches2 = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private PrimaryHand primaryHand;

    @Column(unique = true)
    private int ranking;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column
    private String nationality;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private BigDecimal careerPoints;

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

    public Player(User user, PrimaryHand primaryHand, LocalDate birthDate, Gender gender, String nationality){
        super();
        this.user = user;
        this.primaryHand = primaryHand;
        this.birthDate = birthDate;
        this.gender = gender;
        this.nationality = nationality;
    }

}
