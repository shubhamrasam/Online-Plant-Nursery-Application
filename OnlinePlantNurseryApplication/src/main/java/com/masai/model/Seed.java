package com.masai.model;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seed {

	private Integer seedid;  
	
	@UniqueElements
	private String commonName;
	private String bloomTime; 
	private String watering;
	private String difficultyLevel; 
	private String temparature; 
	private String typeOfSeeds;
	private String seedsDescription;
	private Integer seedsStock;
	private Double seedsCost;
	private Integer seedsPerPacket;
	
}
