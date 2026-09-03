package com.jsp.CollegeAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.CollegeAPI.config.College;
import com.jsp.CollegeAPI.service.CollegeServiceImple;


@Controller
@ResponseBody
public class CollegeController {
	@Autowired
	private CollegeServiceImple collegeServiceImple;
	
	
	@PostMapping("/save")
	public College store(@RequestBody College c) {
		collegeServiceImple.save(c);
		return c;
	
	}
	
	@GetMapping("/get/{id}")
	public College studentById(@PathVariable int id) {
		return collegeServiceImple.get(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public College delStudent(@PathVariable int id) {
		 return collegeServiceImple.deletebyID(id);
		
	}
	@PatchMapping("/patch/{id}/{name}")
	public College partialUpdate(@PathVariable int id , @PathVariable String name) {
		return collegeServiceImple.updatePartially(id, name);
	}
	
	@PutMapping("/put")
	public College completeStudUpdate(@RequestBody College c) {
		return collegeServiceImple.update(c);
	}
	

}
