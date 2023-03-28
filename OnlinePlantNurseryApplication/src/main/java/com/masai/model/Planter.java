
package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planter {

	private Integer planterid; 
	private float planterheight;
	private Integer planterCapacity;
	private Integer drinageHoles;
	private Integer planterColor;
	private String planterShape;
	private Integer planterStock;
	private Integer planterCost;
	private Plant Plant;
	private Seed Seed;
	
}
