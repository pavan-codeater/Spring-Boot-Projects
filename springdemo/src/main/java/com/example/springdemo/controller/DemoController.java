package com.example.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.Coach;

@RestController
public class DemoController {

	private Coach theCoach;
	
	@Autowired
	public DemoController(Coach theCoach){
		this.theCoach=theCoach;
	}
	
	
	@GetMapping("/dailyWorkouts")
	public String getDailyWorkout() {
		return theCoach.getDailyWorkouts()
;	}
	
	
	

}
