package com.demo.tennistournament;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TennisTournamentApplicationTests {

	@Test
	void contextLoads() {
		String str = "Junitworks";
		assertEquals("Junitwsorks",str);
	}

}
