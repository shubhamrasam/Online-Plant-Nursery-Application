package com.masai;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@Configurable
public class OnlinePlantNurseryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinePlantNurseryApplication.class, args);
	}
	
	
}
