package com.demo.tennistournament.repository.jpa;

import com.demo.tennistournament.entity.Court;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourtJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Court findById(short id){
        return entityManager.find(Court.class, id);
    }
}
