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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "person")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Person implements Serializable {
	private static final long serialVersionUID = -1152319083414061470L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idPerson", unique = true, nullable = false, precision = 10, scale = 0)
	@JsonIgnore
	protected Integer id;

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
}