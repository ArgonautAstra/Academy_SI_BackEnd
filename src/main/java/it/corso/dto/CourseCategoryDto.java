package it.corso.dto;

import it.corso.model.NameCategory;

public class CourseCategoryDto {

	private int id;
	private NameCategory name;

	public int getId() {
		return id;
	}

	public NameCategory getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(NameCategory name) {
		this.name = name;
	}

}
