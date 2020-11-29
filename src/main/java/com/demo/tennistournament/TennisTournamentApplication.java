package com.demo.tennistournament;

import com.demo.tennistournament.repository.jdbc.CourtJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisTournamentApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourtJdbcDao courtJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(TennisTournamentApplication.class, args);
	}

	@Override
	public void run(String... args) throws InterruptedException {
		Thread.sleep(1000);
		logger.info("Courts -> {}", courtJdbcDao.findAll());
	}
}
