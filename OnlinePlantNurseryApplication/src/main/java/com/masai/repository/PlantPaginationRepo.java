package com.masai.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Plant;

@Repository
public interface PlantPaginationRepo extends PagingAndSortingRepository<Plant, Integer>{

}
