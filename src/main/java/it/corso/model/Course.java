package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "corso")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_C")
	private int id;

	@Column(name = "Nome_Corso")
	private String name;

	@Column(name = "Descrizione_breve")
	private String descriptionSumm;

	@Column(name = "Descrizione_completa")
	private String descriptionFull;
	
	@Column(name = "Durata")
	private int duration;
	
	@Column(name = "Voto")
	private int rate;
	
	@Column(name = "Percorso")
	private String path;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable
	(
		name = "utenti_corsi", 
		joinColumns = @JoinColumn(name = "FK_CU", referencedColumnName = "ID_C"),
		inverseJoinColumns = @JoinColumn(name = "FK_UC", referencedColumnName = "ID_U")
	)
	private List<User> users = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "FK_CA", referencedColumnName = "ID_CA")
	private Category category;

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

	public List<User> getUtenti() {
		return users;
	}

	public Category getCategory() {
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

	public void setUtenti(List<User> utenti) {
		this.users = utenti;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
