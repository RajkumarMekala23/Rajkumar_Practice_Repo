package com.verinon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinon.model.Course;
import com.verinon.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		return courseRepository.findAll();

	}

	public String upsert(Course course) {
		courseRepository.save(course);
		return "success";
	}

	public Course getById(int id) {
		return courseRepository.findById(id).get();

	}
	public String deleteById(int id){
		courseRepository.deleteById(id);
		return "Deleted....";
		
	}

}
