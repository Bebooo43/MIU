package edu.miu.cs544.lab15.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.lab15.domain.Course;
import edu.miu.cs544.lab15.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping
	public List<Course> findAll(){
		return courseRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Course findById(@PathVariable(name = "id") Long id){
		return courseRepository.findById(id).get();
	}
}
