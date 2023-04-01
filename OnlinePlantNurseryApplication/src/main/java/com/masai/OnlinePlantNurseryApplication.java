package com.masai;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.masai.dataLoader.Data;
import com.masai.repository.PlantRepository;
import com.masai.repository.PlanterRepository;
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
	@Bean
	public CommandLineRunner addPlanter(PlanterRepository planterRepo) {
		return args->{
			Data data=new Data();
			data.addPlanter(planterRepo);
		};
	}
   
}

