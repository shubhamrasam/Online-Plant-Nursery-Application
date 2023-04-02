package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Cart;

import jakarta.transaction.Transactional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	public List<Cart> findBycustomerId(Integer customerId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Cart c WHERE c.customerId = ?1")
	public void deleteFromcustomerId(Integer customerId);
}
