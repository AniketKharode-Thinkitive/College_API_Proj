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

	public College findById(String id);

     @Query("SELECT c FROM College c WHERE c.city = :city")
    List<College> getCollegesByCity(
            @Param("city") String city
    );

    // 8. Search name or city
    @Query("""
           SELECT c FROM College c
           WHERE c.name LIKE %:keyword%
           OR c.city LIKE %:keyword%
           """)
    List<College> searchCollege(
            @Param("keyword") String keyword);
	List<College> findByNameContaining(String name);

    // 4. Find colleges whose name starts with given text
    List<College> findByNameStartingWith(String name);

    // 5. Find by city AND name
    List<College> findByCityAndName(String city, String name);

    // 6. Find by city OR name
    List<College> findByCityOrName(String city, String name);
}


