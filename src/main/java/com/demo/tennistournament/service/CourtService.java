package com.demo.tennistournament.service;

import com.demo.tennistournament.model.Court;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourtService {

    public enum Status{
        SUCCESS, FAILURE;
    }

    private static List<Court> courts = new ArrayList<>();

    static {
        Court court1 = new Court("Court1",(short)10000);
        courts.add(court1);

        Court court2 = new Court("Court2",(short)20000);
        courts.add(court2);

        Court court3 = new Court("Court3",(short)30000);
        courts.add(court3);
    }

    public Court findByName(String name){
        for(Court court : courts){
            if(court.getName().equals(name))
                return court;
        }
        return null;
    }

    public List<Court> findAll(){
        return courts;
    }

    public Status deleteByName(String name){
        Iterator<Court> iterator = courts.iterator();
        while(iterator.hasNext()){
            Court court = iterator.next();
            if(court.getName().equals(name)){
                iterator.remove();
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
}
