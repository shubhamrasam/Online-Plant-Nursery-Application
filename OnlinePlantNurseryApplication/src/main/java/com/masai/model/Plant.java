package com.masai.model;

import jakarta.persistence.Entity;

@Entity
public class Plant {

	private Integer plantId;
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
	
}
