package com.cg.bookmydoctor.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Appointment")
public class Appointment {
	
	@Id
	@Column(name = "appointmentId", unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int appointmentId;
	
	@OneToOne(targetEntity = Doctor.class, fetch = FetchType.EAGER)
	private Doctor doctor;
	
	@OneToOne(targetEntity = Patient.class, fetch = FetchType.EAGER)
	private Patient patient;
	
	@Column(name="appointmentDate")
	private LocalDateTime appointmentDate;
	
	@Column(name="appointmentStatus")
	private String appointmentStatus;//approved ,cancelled,completed	
	
	public Appointment() {}

	
	public Appointment(int appointmentId, Doctor doctor, Patient patient, LocalDateTime appointmentDate,
			String appointmentStatus) {
		super();
		this.appointmentId = appointmentId;
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
	}

	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", doctor=" + doctor + ", patient=" + patient
				+ ", appointmentDate=" + appointmentDate + ", appointmentStatus=" + appointmentStatus + "]";
	}
	
	
	
}
