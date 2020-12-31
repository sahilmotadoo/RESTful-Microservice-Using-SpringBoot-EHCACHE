package com.word.select;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/* Entry point for the SpringBoot program */

@SpringBootApplication
@EnableCaching
public class WordSelectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordSelectApplication.class, args);
	}

}
