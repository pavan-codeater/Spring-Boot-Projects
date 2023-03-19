package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.Entity.Student;

public interface StudentDAO {

	void studentSave(Student student);
	
	   Student  getId(int id);
	   
	   
	List<Student> findAllStudents();
		
	List<Student> findByLastName(String lastName);
	

	void updateInfo(Student s);
	
	void deleteStudent(int id);
	
	
	
}
