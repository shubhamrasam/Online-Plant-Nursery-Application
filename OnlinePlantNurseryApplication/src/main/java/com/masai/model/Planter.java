
package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @JsonIgnore
	@OneToMany(mappedBy="planter" , cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	private List<Plant> plantList;

    @JsonIgnore
	@OneToMany(mappedBy="planter" ,cascade = CascadeType.ALL,fetch =FetchType.EAGER )
	private List<Seed> seedList;
	
}
