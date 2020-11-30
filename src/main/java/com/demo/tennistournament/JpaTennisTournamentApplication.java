package com.demo.tennistournament;

import com.demo.tennistournament.entity.Court;
import com.demo.tennistournament.repository.jpa.CourtJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaTennisTournamentApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourtJpaRepository courtJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaTennisTournamentApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        Thread.sleep(1000);
        logger.info("Court Id 1 ->{}", courtJpaRepository.findById((short) 1));

//		logger.info("Capacity less ->{}",dao.findWhereCapacityIsLessThan((short) 4000));
//		logger.info("%n");
//		logger.info("Capacity greater ->{}",dao.findWhereCapacityIsGreaterThanOrEqual((short) 5000));
//		logger.info("Delete by Id -> No of rows deleted {}", dao.deleteById((short) 4));

//		courtJpaRepository.insert(new Court("namenew",(short)10001));
        //	courtJpaRepository.update(new Court((short)1,"updatedName",(short)7777));
//        courtJpaRepository.deleteById((short) 1);
//        courtJpaRepository.insert(new Court("namenew", (short) 10001));

        logger.info("Courts ->{}", courtJpaRepository.findAll());


    }
}
