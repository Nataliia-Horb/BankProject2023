package com.project.bankproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.project.bankproj.*")
public class BankProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankProjApplication.class, args);
	}

}
