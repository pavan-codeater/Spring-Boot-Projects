package com.example.springdemo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

	public TennisCoach() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyWorkouts() {
		
		return "Play Daily Tennis";
	}

	
	
	
	
}
