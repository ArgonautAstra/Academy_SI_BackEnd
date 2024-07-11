package it.corso.dao;

import java.util.List;

import it.corso.model.Course;

public interface CustomizedCourseDao{

	List<Course> findCourse(String name, int categoryId);
	
}
