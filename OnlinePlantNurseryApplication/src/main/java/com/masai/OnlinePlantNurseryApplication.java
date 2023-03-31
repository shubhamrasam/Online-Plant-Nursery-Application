package com.masai;

import org.apache.catalina.filters.CorsFilter;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.masai.dataLoader.Data;
import com.masai.model.Plant;
import com.masai.model.Seed;
import com.masai.repository.PlantRepository;
import com.masai.repository.SeedRepository;



@SpringBootApplication
@Configurable
public class OnlinePlantNurseryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinePlantNurseryApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(PlantRepository plantrepo) {
		return args->{
		Data data=new Data();
		data.addPlantData(plantrepo);
			
		};
	}
	
	@Bean
	public CommandLineRunner addSeed(SeedRepository seedRepo) {
		return args->{
			Data data=new Data();
			data.addSeed(seedRepo);
		};
	}
    
   
}

