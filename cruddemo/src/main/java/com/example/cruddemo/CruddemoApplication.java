package com.example.cruddemo;


import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.Entity.Student;
import com.example.cruddemo.dao.StudentDAO;

@SpringBootApplication
public class CruddemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		return runner->{
			createStudent(studentDAO);
			
			//readStudent(studentDAO);
				
//			findAllStudents(studentDAO);	
//			
//			findAllStudentByLastName(studentDAO);
			
//			updateStudentInfo(studentDAO);
			
		//	deleteStudent(studentDAO);
			
		};
		
	}
	
	
	

	private void deleteStudent(StudentDAO studentDAO) {
		
		
		int id=0;
		
		//if(id<=0) System.out.println("Deletion not possible");
		
		studentDAO.deleteStudent(id);
		
		
		if(id>0)
		System.out.println("Delete Successfull");
		else
			System.out.println("Delete unsuccess");
		
	}

	private void updateStudentInfo(StudentDAO studentDAO) {
		
		int id=1;
		
		Student s=studentDAO.getId(id);
		
		s.setEmail("Harry@gmail.com");
		//s.setId(3);
		
		studentDAO.updateInfo(s);
		
		System.out.println("Update Successfull");
		
		
		
	}

	private void findAllStudentByLastName(StudentDAO studentDAO) {
	
		List<Student> res=studentDAO.findByLastName("uuuu");
		
		if(res.size()==0)
		System.out.println("Empty");
		
		
		
	}

	private void findAllStudents(StudentDAO studentDAO) {
		
		List<Student> res=studentDAO.findAllStudents();
		
		System.out.println(res);
		
		
	}

	private void readStudent(StudentDAO studentDAO) {
		
		Student s1=new Student("Potter","L S","tom@gmail.com");
		
		studentDAO.studentSave(s1);
		
		Student temp=studentDAO.getId(s1.getId());
		
		System.out.println("Read operation success");
	}

	// Creating Student
	private void createStudent(StudentDAO studentDAO) {
		
		System.out.println("creating Student Object");
		
		Student s1=new Student("Chota","L S","Chota@gmail.edu.com");
		
		studentDAO.studentSave(s1);
		
		System.out.println("ID is   "+s1.getId());
		
		
	}
	
	
}
