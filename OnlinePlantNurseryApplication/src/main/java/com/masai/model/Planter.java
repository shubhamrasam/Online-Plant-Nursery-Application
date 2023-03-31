
package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Planter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planterid; 
	private Integer planterheight;
	private Integer planterCapacity;
	private Integer drinageHoles;
	private String planterColor;
	private String planterShape;
	private Integer planterStock;
	private Integer planterCost;

    
	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "plantId")
	private Plant plant;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	@JoinColumn(name = "seedId")
	private Seed seed;


}
