package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cruddemo.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

	
	private EntityManager entityManager;
	
	
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	
	// CRUD operations below
	
	
	
	
	@Override
	@Transactional
	public void studentSave(Student student) {
		
		entityManager.persist(student);
	}

	@Override
	@Transactional
	public Student getId(int id) {
		
		return entityManager.find(Student.class,id);
	}

	@Override
	public List<Student> findAllStudents() {
		
		TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student order by firstName asc",Student.class);
		
		
		
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public List<Student> findByLastName(String theLastName) {
		TypedQuery q=entityManager.createQuery("FROM Student Where firstName=:data",Student.class);
		
		q.setParameter("data",theLastName);
		
		return q.getResultList();
	}

	@Override
	@Transactional
	public void updateInfo(Student s) {
		
		entityManager.merge(s);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		
		if(id<=0) return;
		
		Student s=entityManager.find(Student.class, id);
		entityManager.remove(s);
	}

	
	
	
	

}
