package it.corso.dto;

import java.util.ArrayList;
import java.util.List;

public class CourseDto {

	private int id;
	private String name;
	private String descriptionSumm;
	private String descriptionFull;
	private int duration;
	private int rate;
	private String path;
	private List<CourseUserDto> users = new ArrayList<>();
	private CourseCategoryDto category;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescriptionSumm() {
		return descriptionSumm;
	}

	public String getDescriptionFull() {
		return descriptionFull;
	}

	public int getDuration() {
		return duration;
	}

	public int getRate() {
		return rate;
	}

	public String getPath() {
		return path;
	}

	public List<CourseUserDto> getUsers() {
		return users;
	}

	public CourseCategoryDto getCategory() {
		return category;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescriptionSumm(String descriptionSumm) {
		this.descriptionSumm = descriptionSumm;
	}

	public void setDescriptionFull(String descriptionFull) {
		this.descriptionFull = descriptionFull;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setUsers(List<CourseUserDto> users) {
		this.users = users;
	}

	public void setCategory(CourseCategoryDto category) {
		this.category = category;
	}

}
