package com.omnicell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories("com.omnicell.repository")
public class OmniCellApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmniCellApplication.class, args);
	}

}
