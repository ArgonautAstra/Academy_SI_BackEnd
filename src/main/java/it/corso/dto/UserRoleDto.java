package it.corso.dto;

import it.corso.model.Tipology;

public class UserRoleDto {

	private int id;
	private Tipology tipology;
	
	public int getId() {
		return id;
	}
	
	public Tipology getTipology() {
		return tipology;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTipology(Tipology tipology) {
		this.tipology = tipology;
	}
	
}
