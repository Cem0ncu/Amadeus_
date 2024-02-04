package com.example.amadeus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//do not know why it is not functioning without scanning AirportMapper
@ComponentScan({"com.example.amadeus.mappers"})

public class AmadeusApplication{

	public static void main(String[] args) {
		SpringApplication.run(AmadeusApplication.class, args);
	}

}
