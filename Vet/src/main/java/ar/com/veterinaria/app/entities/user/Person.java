package ar.com.veterinaria.app.entities.user;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ar.com.veterinaria.app.entities.Address;

import javax.persistence.InheritanceType;
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "personType")
//@AllArgsConstructor
//@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "Person")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Person implements Serializable {

	private static final long serialVersionUID = -1152319083414061470L;

	// @TableGenerator(name = "PERSON_GEN", table = "ID_PERSON", pkColumnName =
	// "idPerson", valueColumnName = "GEN_VAL", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // , generator = "PERSON_GEN")
	@Column(name = "idPerson", unique = true, nullable = false)
	@JsonIgnore
	protected Integer idPerson;

	@Column(name = "name", nullable = false, length = 50)
	protected String name;

	@Column(name = "surname", nullable = false, length = 50)
	protected String surname;

	@Column(name = "dni", nullable = false, length = 11)
	protected Integer dni;

	@Column(name = "birthday", nullable = true, length = 11)
	protected String birthday;

	@Column(name = "telephone", nullable = true, length = 11)
	protected Integer telephone;

	@Column(name = "cellphone", nullable = false, length = 15)
	protected Integer cellphone;

	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idAddress", nullable = true)
	protected Address address;

	public Person() {
		super();
	}

	public Person(Integer idPerson, String name, String surname, Integer dni, String birthday, Integer telephone,
			Integer cellphone, Address address) {
		super();
		this.idPerson = idPerson;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.birthday = birthday;
		this.telephone = telephone;
		this.cellphone = cellphone;
		this.address = address;
	}

	public Person(Integer idPerson, String name, String surname, Integer dni, String birthday, Integer cellphone,
			Address address) {
		super();
		this.idPerson = idPerson;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.birthday = birthday;
		this.cellphone = cellphone;
		this.address = address;
	}

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public Integer getCellphone() {
		return cellphone;
	}

	public void setCellphone(Integer cellphone) {
		this.cellphone = cellphone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}