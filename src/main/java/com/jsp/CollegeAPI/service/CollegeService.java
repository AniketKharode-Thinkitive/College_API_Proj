package com.jsp.CollegeAPI.service;

import com.jsp.CollegeAPI.config.College;

public interface CollegeService {
	
	public College save(College c);
	public College get(int id);
	public College deletebyID(int id);
	public College updatePartially(int id , String name);
	public College update(College c);
	

}
