package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	@NotNull(message = "Mobile no Should not be null")
	@Pattern(regexp = "[6-9]{1}[0-9]{9}",message = "Mobile no should be of 10 digit only")
	private String customerMobileNumber;
	@NotNull(message = "Customer Password Should not be null")
	@Size(min = 8,max = 15,message = "Password should be Min 8 character and max 15 character")
	private String customerPassword;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Orders> orderList;
	
}
