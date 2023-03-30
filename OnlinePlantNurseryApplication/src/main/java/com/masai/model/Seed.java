package com.masai.model;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seedid;  
	
	
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
