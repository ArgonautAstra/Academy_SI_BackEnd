package it.corso.dto;

public class CourseAddRequestDto {

	private int id;
	private String name;
	private String descriptionSumm;
	private String descriptionFull;
	private int duration;
	private int category;

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
	public int getCategory() {
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

	public void setCategory(int category) {
		this.category = category;
	}

}
