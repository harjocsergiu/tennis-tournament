package com.demo.tennistournament.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="match_id")
    private Match match;

    @Column
    private BigDecimal price;

    @Column
    private Short seat;

    protected Ticket(){}
}
