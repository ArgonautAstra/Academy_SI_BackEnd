package it.corso.dto;

import java.util.List;

public class RoleUserDto {
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private List<UserCourseDto> courses;

	public int getId() {
		return id;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<UserCourseDto> getCourses() {
		return courses;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCourses(List<UserCourseDto> courses) {
		this.courses = courses;
	}
	
}
