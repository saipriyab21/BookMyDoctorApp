package com.cg.bookmydoctor.controller;

import java.math.BigInteger; 
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.Patient;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.exception.PatientException;
import com.cg.bookmydoctor.service.DoctorServiceImpl;
import com.cg.bookmydoctor.service.PatientServiceImpl;


@CrossOrigin("http://localhost:3500")
@RestController
@RequestMapping("/PatientService")

public class PatientController {
	@Autowired(required = true)
	PatientServiceImpl PatientService;

	
	@PostMapping("/addPatient")
	@ExceptionHandler(PatientException.class)
	public Patient addPatient(@RequestBody Patient bean) {
		return PatientService.addPatient(bean);
	}

	
	@PutMapping("/updatePatient")
	@ExceptionHandler(PatientException.class)
	public Patient editPatientProfile(@RequestBody Patient bean) {
		return PatientService.editPatientProfile(bean);
	}
	
	
	@DeleteMapping("/removePatientDetailsr")
	@ExceptionHandler(PatientException.class)
	public Patient removePatientDetails(@RequestBody Patient bean) {
		return PatientService.removePatientDetails(bean);
	}
	
	
	@GetMapping("/getPatient")
	@ExceptionHandler(PatientException.class)
	public Patient getPatient(@RequestBody Patient Patient) {
		return PatientService.getPatient(Patient);
	}

	
	@GetMapping("/allPatient")
	public List<Patient> getAllPatient() {
		return PatientService.getAllPatient();
	}
	
	@GetMapping("/allPatientByDoctor")
	public List<Patient> getPatientListByDoctor(Doctor doc) {
		return PatientService.getPatientListByDoctor(doc);
	}
	
	
	@GetMapping("/allPatienByDate")
	public List<Patient> getPatientListByDate(LocalDate appdate) {
		return PatientService.getPatientListByDate(appdate);
	}
}
