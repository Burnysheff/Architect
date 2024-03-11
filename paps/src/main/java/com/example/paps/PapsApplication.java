package com.example.paps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.paps.*")
@ComponentScan(basePackages = { "com.example.paps.*" })
@EntityScan("com.example.paps.*")
public class PapsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PapsApplication.class, args);
	}

}
