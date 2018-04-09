package com.three.base.userweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("com.three.base")
public class UserWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserWebApplication.class, args);
	}
}
