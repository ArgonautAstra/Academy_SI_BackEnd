package it.corso.service;

import java.util.List;

import it.corso.dto.CourseAddRequestDto;
import it.corso.dto.CourseDto;
import it.corso.dto.CourseUpdateDto;
import it.corso.model.Course;

public interface CourseService {

	void createCourse(CourseAddRequestDto courseDto);

	void updateCourse(CourseUpdateDto courseUpdateDto);

	void deleteCourse(int id);

	CourseDto getCourseById(int id);

	List<CourseDto> getAllCourse();

	List<Course> findByCategory(int id);

	void deleteByCategory(int id);

}