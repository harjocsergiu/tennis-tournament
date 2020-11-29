package com.demo.tennistournament;

import com.demo.tennistournament.entity.Court;
import com.demo.tennistournament.repository.jdbc.CourtJdbcDao;
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
	CourtJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(JpaTennisTournamentApplication.class, args);
	}

	@Override
	public void run(String... args) throws InterruptedException {
		Thread.sleep(1000);

	}
}
