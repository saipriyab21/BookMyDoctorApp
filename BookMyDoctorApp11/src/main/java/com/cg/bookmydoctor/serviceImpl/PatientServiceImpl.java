package com.cg.bookmydoctor.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.service.IPatientService;
import com.cg.bookmydoctor.dao.IPatientDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List; 
import java.util.Optional;

import com.cg.bookmydoctor.dao.*;

@Service
public class PatientServiceImpl implements IPatientService {
	@Autowired
	private IPatientDao patientDao;
	
	@Autowired
	private IAppointmentDao appointmentDao;
	Appointment a;
	
	Patient patient = new Patient();

	@Override
	//working
	public Patient addPatient(Patient bean) {
		//Optional<Doctor> findById = docDao.findById(dr.getDoctorId());
		if(bean == null) {
			throw new PatientException("Passed object can't be null");
		} else {
			return patientDao.save(bean);
		}
	}

	@Override
	//working
	public Patient editPatientProfile(Patient bean) {
		Optional<Patient> patientDb = patientDao.findById(bean.getPatientId());
		if (patientDb.isPresent()) {
			patientDao.save(bean);
		} 
		else
			throw new PatientException("Patient with ID: " + bean.getPatientId() + "does not exists");
		return bean;

	} 
		
	@Override
	//working
	public Patient removePatientDetails(Patient bean) {
		Patient patient = bean;
		Optional<Patient> docdb = patientDao.findById(bean.getPatientId());
		if(docdb.isPresent()) {
			patientDao.delete(bean);	
		} else {
			throw new PatientException("The passed object can't be null");
		}
		return patient;
	}
	
	@Override
	//working
	public Patient getPatient(Patient patient) {
		Optional<Patient> patientDb = patientDao.findById(patient.getPatientId());
		if(patientDb.isPresent()) {
			return patientDb.get();
		}
		else {
			return null;
		}
	}
	
	@Override
	//working
	public List<Patient> getAllPatient(){
		Iterable<Patient> result = patientDao.findAll();
		List<Patient> resultList = new ArrayList<>();
		result.forEach(resultList :: add);
		return resultList;
	}
	
	@Override
	public List<Patient> getPatientListByDoctor(Doctor doctor){
		List<Patient> pat = new ArrayList<>();
		Optional<Appointment> optdocAppt = appointmentDao.findById(doctor.getDoctorId());
		Optional<Appointment> optpatientAppt = appointmentDao.findById(patient.getPatientId());
		//Iterable<Patient> optPatient = patientDao.findAll();
		List<Patient> patientList = new ArrayList<>();
		patientList.addAll(getAllPatient());
		if(optdocAppt.isPresent() && optpatientAppt.isPresent()) {
			pat.add(patient);
		}
		return pat;
	}
	
	@Override
	public List<Patient> getPatientListByDate(LocalDate appdate){
		List<Patient> p1 = new ArrayList<>();
		LocalDate localDate = a.getAppointmentDate();
		if(localDate == appdate) {
			p1.add(a.getPatient());
		}
		return p1;
	}
}