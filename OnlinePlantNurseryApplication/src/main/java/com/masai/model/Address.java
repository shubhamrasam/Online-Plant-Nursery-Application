package com.masai.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	
	@NotNull
	@Size(min=3 , max=4 ,message = "House Number should be in between three and four digit only")
	private String houseNumber;
	
	@NotNull
	private String colony;
	
	@NotNull
	private String city;
	
	@NotNull
	private String state;
	
	@NotNull
	@Pattern(regexp = "[4,5,6,7,8,9]{1}[0-9]{5}",message = "Pincode should be six digit only")
	private String pincode;
	
}
