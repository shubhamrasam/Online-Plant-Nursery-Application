package com.masai.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Seed;

@Repository
public interface SeedPaginationRepo extends PagingAndSortingRepository<Seed, Integer>{

}
