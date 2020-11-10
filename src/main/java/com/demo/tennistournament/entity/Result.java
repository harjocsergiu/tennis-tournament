package com.demo.tennistournament.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Result {

    private String set1;
    private String set2;
    private String set3;

    protected Result(){}

    public Result(String set1, String set2) {
        super();
        this.set1 = set1;
        this.set2 = set2;
    }

    public Result(String set1, String set2, String set3) {
        super();
        this.set1 = set1;
        this.set2 = set2;
        this.set3 = set3;
    }
}
