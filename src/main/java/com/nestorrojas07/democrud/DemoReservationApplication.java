package com.nestorrojas07.democrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoReservationApplication.class, args);
	}

}
