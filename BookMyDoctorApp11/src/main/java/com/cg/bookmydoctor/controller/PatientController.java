package com.cg.bookmydoctor.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.serviceImpl.PatientServiceImpl;


//@CrossOrigin("http://localhost:3500")
@RestController
@RequestMapping("/patient")

public class PatientController {
	@Autowired(required = true)
	PatientServiceImpl PatientService;

	//working
	@PostMapping("/addpatient")
	@ExceptionHandler(PatientException.class)
	public Patient addPatient(@RequestBody Patient bean) {
		return PatientService.addPatient(bean);
	}

	//working
	@PutMapping("/updatepatient")
	@ExceptionHandler(PatientException.class)
	public Patient editPatientProfile(@RequestBody Patient bean) {
		return PatientService.editPatientProfile(bean);
	}
	
	//working
	@DeleteMapping("/removepatientdetails")
	@ExceptionHandler(PatientException.class)
	public Patient removePatientDetails(@RequestBody Patient bean) {
		return PatientService.removePatientDetails(bean);
	}
	
	//working
	@GetMapping("/getpatient/{patientId}")
	@ExceptionHandler(PatientException.class)
	public Patient getPatient(@PathVariable("patientId") Patient Patient) {
		return PatientService.getPatient(Patient);
	}

	//working
	@GetMapping("/allpatient")
	public List<Patient> getAllPatient() {
		return PatientService.getAllPatient();
	}
	
	@GetMapping("/allpatientbydoctor")
	public List<Patient> getPatientListByDoctor( Doctor doc) {
		return PatientService.getPatientListByDoctor(doc);
	}
	
	
	@GetMapping("/allpatienbydate")
	public List<Patient> getPatientListByDate(LocalDate appdate) {
		return PatientService.getPatientListByDate(appdate);
	}
}