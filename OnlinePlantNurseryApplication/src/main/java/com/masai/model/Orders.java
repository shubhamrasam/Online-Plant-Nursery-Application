package com.masai.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@JsonIgnore
	private Integer bookingOrderId;
	@JsonIgnore
	private LocalDateTime orderDateTime;
	private String transcationMode;
	private Integer quantity;
	private Double totalCost;
	
	@OneToOne(mappedBy = "order",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="planterId")
	@JsonIgnore
	private Planter planters;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name="customerId")
	private Customer customer;

	@Override
	public String toString() {
		return "Orders [bookingOrderId=" + bookingOrderId + ", orderDateTime=" + orderDateTime + ", transcationMode="
				+ transcationMode + ", quantity=" + quantity + ", totalCost=" + totalCost + ", planters=" + planters
				+ "]";
	}
	
}
