package com.lab.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DbApplication {
	@Autowired
	private App app;

	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}

	@PostConstruct
	public void run() {
		app.start();
	}

}
