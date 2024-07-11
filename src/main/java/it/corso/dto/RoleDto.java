package it.corso.dto;

import java.util.ArrayList;
import java.util.List;

import it.corso.model.Tipology;

public class RoleDto {

	private int id;
	private Tipology tipology;
	private List<RoleUserDto> users = new ArrayList<>();

	public int getId() {
		return id;
	}

	public Tipology getTipology() {
		return tipology;
	}

	public List<RoleUserDto> getUsers() {
		return users;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTipology(Tipology tipology) {
		this.tipology = tipology;
	}

	public void setUsers(List<RoleUserDto> users) {
		this.users = users;
	}

}
