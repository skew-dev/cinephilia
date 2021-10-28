package com.skew.cinephilia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinephiliaApplication {

	public static void main(String[] args) {
		//This log should be deleted on next commit
		System.out.println("Delete me!");
		SpringApplication.run(CinephiliaApplication.class, args);
	}

}
