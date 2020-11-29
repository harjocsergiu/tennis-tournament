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
public class SpringJdbcDemoApp implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourtJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApp.class, args);
	}

	@Override
	public void run(String... args) throws InterruptedException {
		Thread.sleep(1000);
//		logger.info("All Courts-> {}",dao.findAll());
//		logger.info("Court Id 1 ->{}",dao.findById((short) 1));
//		logger.info("Capacity less ->{}",dao.findWhereCapacityIsLessThan((short) 4000));
//		logger.info("%n");
//		logger.info("Capacity greater ->{}",dao.findWhereCapacityIsGreaterThanOrEqual((short) 5000));
		logger.info("Delete by Id -> No of rows deleted {}", dao.deleteById((short) 4));
		dao.insert(new Court((short)1000,"namenew",(short)10001));
		dao.update(new Court((short)1000,"updatedName",(short)7777));
	}
}
