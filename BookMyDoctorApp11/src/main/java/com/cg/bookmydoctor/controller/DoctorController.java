package com.cg.bookmydoctor.controller;

import java.math.BigInteger;   
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
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.service.DoctorServiceImpl;


@CrossOrigin("http://localhost:3500")
@RestController
@RequestMapping("/Doctor")
public class DoctorController {
	@Autowired(required = true)
	DoctorServiceImpl doctorService;

	
	@PostMapping("/addDoctor")
	@ExceptionHandler(DoctorException.class)
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}

	
	@PutMapping("/updateDoctor")
	@ExceptionHandler(DoctorException.class)
	public Doctor updateDoctorProfile(@RequestBody Doctor doctor) {
		return doctorService.updateDoctorProfile(doctor);
	}
	
	@PostMapping("/addAvailability")
	@ExceptionHandler(DoctorException.class)
	public boolean addAvailability(@RequestBody AvailabilityDates bean) {
		return doctorService.addAvailability(bean);
	}
	
	@PostMapping("/updateAvailability")
	@ExceptionHandler(DoctorException.class)
	public boolean updateAvailability(@RequestBody AvailabilityDates bean) {
		return doctorService.updateAvailability(bean);
	}
	
	@GetMapping("/getDoctor")
	@ExceptionHandler(DoctorException.class)
	public Doctor getDoctor(@RequestBody Doctor doctor) {
		return doctorService.getDoctor(doctor);
	}

	
	@DeleteMapping("/removeDoctor")
	@ExceptionHandler(DoctorException.class)
	public Doctor removeDoctor(@RequestBody Doctor doctor) {
		return doctorService.removeDoctor(doctor);
	}
	
	@GetMapping("/allDoctors")
	public List<Doctor> getDoctorList() {
		return doctorService.getDoctorList();
	}
	
	@GetMapping("/allDoctors/{id}")
	public List<Doctor> getDoctorList(String speciality) {
		return doctorService.getDoctorList(speciality);
	}
}
