package com.masai;

import org.apache.catalina.filters.CorsFilter;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@Configurable
public class OnlinePlantNurseryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinePlantNurseryApplication.class, args);
	}

	  @Bean
	    public CorsFilter corsFilter() {
	        CorsFilter filter = new CorsFilter();
	        return filter;
	    }
	
	
}
