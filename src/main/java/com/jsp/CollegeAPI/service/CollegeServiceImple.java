package com.jsp.CollegeAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.CollegeAPI.config.College;
import com.jsp.CollegeAPI.repo.CollegeRepo;

@Service
public class CollegeServiceImple implements CollegeService{
	@Autowired
	private CollegeRepo collegeRepo;


	@Override
	public College save(College c) {
		collegeRepo.save(c);
		return c;
	}

	@Override
	public College get(int id) {
		College college = collegeRepo.findById(id).get();
		return college;
	}

	@Override
	public College deletebyID(int id) {
		College college = collegeRepo.findById(id).get();
		collegeRepo.delete(college);
		return college;
	}

	@Override
	public College updatePartially(int id, String name) {
		College college = collegeRepo.findById(id).get();
		college.setName(name);
		collegeRepo.save(college);
		return college;
	}

	@Override
	public College update(College c) {
		College college = collegeRepo.findById(c.getId()).get();	
		college.setName(c.getName());
		college.setCity(c.getCity());
		collegeRepo.save(college);
		return college;
		
		}
}
