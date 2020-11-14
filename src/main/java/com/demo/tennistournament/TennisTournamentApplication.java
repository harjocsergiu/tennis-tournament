package com.demo.tennistournament;

import com.demo.tennistournament.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisTournamentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TennisTournamentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
