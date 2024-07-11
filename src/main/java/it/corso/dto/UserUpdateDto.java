package it.corso.dto;

import java.util.List;

import it.corso.model.Role;

public class UserUpdateDto {

	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private List<Role> roles;
	
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
	
	public List<Role> getRoles() {
		return roles;
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

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
