package com.masai.model;


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
public class Plant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  plantId;
	private Integer plantHeight;
	private String plantSpread;
	private String plantCommonName;
	private String bloomTime;
	private String medicinalCulinaryUse;
	private String difficultyLevel;
	private String temparature;
	private String typeOfPlant;
	private String plantDescription;
	private Integer plantStock;
	private Double plantCost;
	private String url;
    


	public Plant(Integer plantHeight, String plantSpread, String plantCommonName, String bloomTime,
			String medicinalCulinaryUse, String difficultyLevel, String temparature, String typeOfPlant,
			String plantDescription, Integer plantStock, Double plantCost, String url) {
		super();
		this.plantHeight = plantHeight;
		this.plantSpread = plantSpread;
		this.plantCommonName = plantCommonName;
		this.bloomTime = bloomTime;
		this.medicinalCulinaryUse = medicinalCulinaryUse;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfPlant = typeOfPlant;
		this.plantDescription = plantDescription;
		this.plantStock = plantStock;
		this.plantCost = plantCost;
		this.url = url;
	}
	

	
}
