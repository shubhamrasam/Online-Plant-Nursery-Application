package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer cartId;
  private Integer price;
  private String name;
  private String url;
  private Category category;
  private Integer customerId;
  
  
  
}
