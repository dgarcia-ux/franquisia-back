package com.franquisia.franquisia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.franquisia.franquisia.repository")
public class FranquisiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FranquisiaApplication.class, args);
	}

}
