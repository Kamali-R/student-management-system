package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping
	public List<Student> getAll() {
		return service.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getById(@PathVariable Long id) {
		return service.getStudentById(id);
	}
	
	@PostMapping
	public Student add(@RequestBody Student s) {
		return service.saveStudent(s);
	}
	
	@PutMapping("/{id}")
	public Student update(@PathVariable Long id,@RequestBody Student s) {
		return service.updateStudent(id, s);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteStudent(id);
		return "Student Deleted";
	}
}