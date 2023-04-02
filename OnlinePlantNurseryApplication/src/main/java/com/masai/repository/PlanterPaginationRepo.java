package com.masai.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Planter;

@Repository
public interface PlanterPaginationRepo extends PagingAndSortingRepository<Planter, Integer>{

}
