package com.luv2code.springboot.demo.mycoolestapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FunRestController {

	
	
	
	
	@GetMapping("/")
	public String FunRestController() {
		return "Hello";
	}
	
	
	

}
