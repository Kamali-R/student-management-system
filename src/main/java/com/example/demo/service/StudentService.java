package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public List<Student> getAllStudents() {
		return repo.findAll();
	}
	
	public Student getStudentById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Student saveStudent(Student s) {
		return repo.save(s);
	}
	
	public Student updateStudent(Long id, Student s) {
		Student existing = repo.findById(id).orElse(null);
		if(existing != null) {
			existing.setName(s.getName());
			existing.setEmail(s.getEmail());
			return repo.save(existing);
		}
		return null;
	}
	
	public void deleteStudent(Long id) {
		repo.deleteById(id);
	}
}
