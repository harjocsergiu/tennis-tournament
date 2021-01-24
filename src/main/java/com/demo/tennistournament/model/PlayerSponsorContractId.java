package com.demo.tennistournament.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PlayerSponsorContractId implements Serializable {

    @Column
    private Long playerId;

    @Column
    private Integer sponsorId;

    protected PlayerSponsorContractId(){}

    public PlayerSponsorContractId(Long player, Integer sponsor) {
        this.playerId = player;
        this.sponsorId = sponsor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PlayerSponsorContractId that = (PlayerSponsorContractId) o;
        return Objects.equals(playerId, that.playerId) &&
                Objects.equals(sponsorId, that.sponsorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, sponsorId);
    }
}
