package com.demo.tennistournament.repository.jpa;

import com.demo.tennistournament.entity.Court;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourtJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Court findById(short id){
        return entityManager.find(Court.class, id);
    }

    public Court update(Court court){
        return entityManager.merge(court);
    }

    public Court insert(Court court){
        return entityManager.merge(court);
    }

    public void deleteById(short id){
        Court court = findById(id);
        entityManager.remove(court);
    }

    public List<Court> findAll(){
        TypedQuery<Court> namedQuery = entityManager.createNamedQuery("find_all_courts",Court.class);
        return namedQuery.getResultList();
    }
}
