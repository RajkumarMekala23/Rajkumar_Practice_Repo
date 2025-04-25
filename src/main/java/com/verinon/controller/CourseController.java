package com.verinon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verinon.model.Course;
import com.verinon.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping("/course/create")
	public ResponseEntity<String> createCourse(@RequestBody Course course){
		String create = courseService.upsert(course);
		return new ResponseEntity<>(create, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List> getAllCourses(){
		List<Course> allCourses = courseService.getAllCourses();
		return new ResponseEntity<>(allCourses,HttpStatus.OK);
		
	}
	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getById(@PathVariable Integer id){
		Course courseId = courseService.getById(id);
		return new ResponseEntity<Course>(courseId, HttpStatus.OK);
	}
	
	@PutMapping("/course/update")
	public ResponseEntity<String> updateCourse(@RequestBody Course course){
		String create = courseService.upsert(course);
		return new ResponseEntity<>(create, HttpStatus.CREATED);
		
	}
	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		String courseId = courseService.deleteById(id);
		return new ResponseEntity<>(courseId, HttpStatus.OK);
	}

}
