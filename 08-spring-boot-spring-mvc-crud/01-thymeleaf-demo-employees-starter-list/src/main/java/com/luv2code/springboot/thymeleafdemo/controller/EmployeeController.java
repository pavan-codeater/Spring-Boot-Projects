package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	
	@Autowired
    public EmployeeController(EmployeeService e) {
		employeeService=e;
	}

	//@PostMapping("/")
	
	
	
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> list=employeeService.findAll();
		
		theModel.addAttribute("employees", list);

		return "employees/list-employees";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model themodel) {
		
		Employee e=new Employee();
		
		themodel.addAttribute("employee",e);
		
		return "employees/employee-form";
		
		
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return "redirect:/employees/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {
		
		Employee e=employeeService.findById(theId);
		
		
		theModel.addAttribute("employee", e);
		
		
		
		
	return "employees/employee-form";
		
		
		
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		
		
		employeeService.deleteById(id);
		
		
		return "redirect:/employees/list";
		
		
	}
	
	
	
}









