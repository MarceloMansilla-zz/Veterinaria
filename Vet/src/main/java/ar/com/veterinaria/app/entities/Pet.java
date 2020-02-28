package ar.com.veterinaria.app.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "pet")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Pet implements Serializable {

	private static final long serialVersionUID = 2710406182764591314L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idPet", unique = true, nullable = false)
	@JsonIgnore
	private Integer id;

	@Column(name = "name", nullable = true, length = 70)
	private String name;

	@Column(name = "birthday", nullable = true, length = 30)
	private String birthday;

	@Column(name = "size", nullable = true, length = 50)
	private String size;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idAnimalBreed", nullable = true)
	private AnimalBreed animalBreed;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idClinicalHistory", nullable = true)
	private ClinicalHistory clinicalHistory;

	public Pet() {
		super();
	}

	public Pet(Integer id, String name, String birthday, String size, AnimalBreed animalBreed,
			ClinicalHistory clinicalHistory) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.size = size;
		this.animalBreed = animalBreed;
		this.clinicalHistory = clinicalHistory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public AnimalBreed getAnimalBreed() {
		return animalBreed;
	}

	public void setAnimalBreed(AnimalBreed animalBreed) {
		this.animalBreed = animalBreed;
	}

	public ClinicalHistory getClinicalHistory() {
		return clinicalHistory;
	}

	public void setClinicalHistory(ClinicalHistory clinicalHistory) {
		this.clinicalHistory = clinicalHistory;
	}

}
