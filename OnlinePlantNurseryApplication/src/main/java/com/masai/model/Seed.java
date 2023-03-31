package com.masai.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

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
	private String url;
	


	public Seed(String commonName, String bloomTime, String watering, String difficultyLevel, String temparature,
			String typeOfSeeds, String seedsDescription, Integer seedsStock, Double seedsCost, Integer seedsPerPacket,
			String url) {
		super();
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfSeeds = typeOfSeeds;
		this.seedsDescription = seedsDescription;
		this.seedsStock = seedsStock;
		this.seedsCost = seedsCost;
		this.seedsPerPacket = seedsPerPacket;
		this.url = url;
	}

	

}
