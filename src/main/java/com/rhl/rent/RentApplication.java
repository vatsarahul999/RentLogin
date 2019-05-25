package com.rhl.rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RentApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RentApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RentApplication.class, args);
	}

}
