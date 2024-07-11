package it.corso.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Category;
import it.corso.model.Course;

public interface CourseDao extends CrudRepository<Course, Integer>, CustomizedCourseDao {
	
	List<Course> findByCategory(Category id);
	
}
