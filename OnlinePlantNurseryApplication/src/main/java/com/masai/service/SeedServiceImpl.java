package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.exception.SeedException;
import com.masai.model.Orders;
import com.masai.model.Seed;
import com.masai.repository.OrdersRepository;

@Service
public class SeedServiceImpl implements SeedService{

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Override
	public Seed addSeed(Seed seed) throws SeedException {
		
//	    Optional<Seed> optSeed = ordersRepository.findById(seed.get);
		
		if(optSeed.isEmpty()) {
			
//			return ordersRepository.save(seed);
		}
		
		throw new OrderException("Order already present with id: "+order.getBookingOrderId());
		
		return null;
	}

	@Override
	public Seed updateSeed(Seed seed) throws SeedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed deleteSeed(Seed seed) throws SeedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed viewSeed(Seed seed) throws SeedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seed viewSeed(String commonName) throws SeedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seed> viewAllSeeds() throws SeedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) throws SeedException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
