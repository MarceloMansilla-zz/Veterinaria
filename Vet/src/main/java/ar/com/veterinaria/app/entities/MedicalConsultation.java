package ar.com.veterinaria.app.entities;

import java.io.Serializable;

public class MedicalConsultation implements Serializable {

	private static final long serialVersionUID = -8021659893493109973L;
	private Integer id;
	private String medicalConsultationDate;
	private String treatment;
	private String observation;

	public MedicalConsultation(Integer id, String medicalConsultationDate, String treatment, String observation) {
		super();
		this.id = id;
		this.medicalConsultationDate = medicalConsultationDate;
		this.treatment = treatment;
		this.observation = observation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMedicalConsultationDate() {
		return medicalConsultationDate;
	}

	public void setMedicalConsultationDate(String medicalConsultationDate) {
		this.medicalConsultationDate = medicalConsultationDate;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

}
