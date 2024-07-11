package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CategoryDao;
import it.corso.dao.CourseDao;
import it.corso.dto.CourseAddRequestDto;
import it.corso.dto.CourseDto;
import it.corso.dto.CourseUpdateDto;
import it.corso.model.Category;
import it.corso.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public void createCourse(CourseAddRequestDto courseDto) {

		Course course = modelMapper.map(courseDto, Course.class);

		System.out.println(course.getDescriptionFull() + " " + course.getDescriptionSumm());
		System.out.println(courseDto.getDescriptionFull() + " " + courseDto.getDescriptionSumm());
			
		Optional<Category> optional = categoryDao.findById(courseDto.getCategory());
		
		if(optional.isPresent()) {
			
			course.setCategory(optional.get());
			
			courseDao.save(course);	
		}
		
		/*
		course.setName(courseDto.getName());
		course.setDescriptionSumm(courseDto.getDescriptionSumm());
		course.setDescriptionFull(courseDto.getDescriptionFull());
		course.setDuration(courseDto.getDuration());
		*/
	}

	@Override
	public void updateCourse(CourseUpdateDto courseUpdateDto) {
		
		Optional<Course> optional = courseDao.findById(courseUpdateDto.getId());
		
		if(optional.isPresent()) {
		
			Course coruseDb = (Course) optional.get();

			coruseDb.setName(courseUpdateDto.getName());
			coruseDb.setDescriptionSumm(courseUpdateDto.getDescriptionSumm());
			coruseDb.setDescriptionFull(courseUpdateDto.getDescriptionFull());
			coruseDb.setDuration(courseUpdateDto.getDuration());
			
			courseDao.save(coruseDb);
		}
		
	}

	@Override
	public void deleteCourse(int id) {
		
	}

	@Override
	public CourseDto getCourseById(int id) {
		
		Optional<Course> optional = courseDao.findById(id);
		
		if(optional.isPresent()) {
			Course course = optional.get();
			
	        return modelMapper.map(course, CourseDto.class);
		}
		
		return new CourseDto();
	}

	@Override
	public List<CourseDto> getAllCourse() {

		List<Course> course = (List<Course>) courseDao.findAll();
		List<CourseDto> courseDto = new ArrayList<>();
		
		course.forEach(u -> courseDto.add(modelMapper.map(u, CourseDto.class)));
		
		return courseDto;
	}
	
	@Override
	public List<Course> findByCategory(int id) {
		
	    Optional<Category> optional = categoryDao.findById(id);
	    
	    if(optional.isPresent()) 
	      return courseDao.findByCategory(optional.get());
	    else 
	      return new ArrayList<Course>();
		
	}
	
	@Override
	public void deleteByCategory(int id) {
		
		List<Course> courseDb = findByCategory(id);
		
		courseDao.deleteAll(courseDb);
		
	}

}
