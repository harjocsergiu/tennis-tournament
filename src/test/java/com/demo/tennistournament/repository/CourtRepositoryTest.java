package com.demo.tennistournament.repository;

import com.demo.tennistournament.entity.Court;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourtRepositoryTest {

    @Autowired
    CourtRepository repository;

    @Test
    public void findById_existentId_returnsValidCourt() {
        Court court = repository.findById((short) 1);
        assertNotNull(court);
        assertEquals("Court1", court.getName());
    }

    @Test
    public void findById_inexistentId_returnsNull() {
        Court court = repository.findById((short) 100);
        assertNull(court);
    }

    @Test
    public void deleteById_existentId(){
        repository.deleteById((short) 1);
    }

}