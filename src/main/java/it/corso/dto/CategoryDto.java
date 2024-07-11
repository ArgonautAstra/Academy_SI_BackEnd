package it.corso.dto;

import java.util.ArrayList;
import java.util.List;

import it.corso.model.NameCategory;

public class CategoryDto {

	private int id;
	private NameCategory name;
	private List<CategoryCourseDto> courses = new ArrayList<>();

	public int getId() {
		return id;
	}

	public NameCategory getName() {
		return name;
	}

	public List<CategoryCourseDto> getCourses() {
		return courses;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(NameCategory name) {
		this.name = name;
	}

	public void setCourses(List<CategoryCourseDto> courses) {
		this.courses = courses;
	}

}
