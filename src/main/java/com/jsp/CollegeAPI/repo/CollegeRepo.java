package com.jsp.CollegeAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.CollegeAPI.config.College;

@Repository
public interface CollegeRepo  extends JpaRepository<College, Integer>{

    @Query
	@Transactional
	public List<College> findByName(String name); 

    @Query
    @Transactional
     public int findByCity(String city) ; 
}


