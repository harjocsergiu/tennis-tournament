package com.demo.tennistournament.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
public class PlayerSponsorContract implements Serializable {

    @EmbeddedId
    private PlayerSponsorContractId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playerId")
    @JoinColumn(name="player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sponsorId")
    @JoinColumn(name="sponsor_id")
    private Sponsor sponsor;

    @Column
    private LocalDateTime expirationDate;

    @Column
    private BigDecimal money;

    @CreationTimestamp
    private LocalDateTime signedOn;

    @UpdateTimestamp
    private LocalDateTime modifiedOn;

    protected PlayerSponsorContract(){}

    public PlayerSponsorContract(Player player, Sponsor sponsor){
        this.player = player;
        this.sponsor = sponsor;
        this.id = new PlayerSponsorContractId(player.getId(),sponsor.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PlayerSponsorContract that = (PlayerSponsorContract) o;
        return Objects.equals(player,that.player) &&
                Objects.equals(sponsor,that.sponsor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player,sponsor);
    }
}
