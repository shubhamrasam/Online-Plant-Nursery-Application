package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class CustomerLoginDTO {

	private String customerMobileNumber;
	private String customerPassword;
	public CustomerLoginDTO(String customerMobileNumber, String customerPassword) {
		super();
		this.customerMobileNumber = customerMobileNumber;
		this.customerPassword = customerPassword;
	}
	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}
	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	
}
