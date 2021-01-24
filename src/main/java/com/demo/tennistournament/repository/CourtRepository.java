package com.demo.tennistournament.repository;

import com.demo.tennistournament.model.Court;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CourtRepository {

    @Autowired
    EntityManager em;

    public Court findById(short id){
        return em.find(Court.class,id);
    }

    public Court update(Court court){
        return em.merge(court);
    }

    public Court insert(Court court){
        return em.merge(court);
    }

    public void deleteById(short id){
        Court court = findById(id);
        em.remove(court);
    }

    public List<Court> findAll(){
        TypedQuery<Court> namedQuery = em.createNamedQuery("find_all_courts",Court.class);
        return namedQuery.getResultList();
    }
}
