package com.cg.bookmydoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cg.bookmydoctor.serviceImpl.DoctorServiceImpl;


//@CrossOrigin("http://localhost:3500")
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired(required = true)
	DoctorServiceImpl doctorService;

	//working
	@PostMapping("/adddoctor")
	@ExceptionHandler(DoctorException.class)
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}

	//working
	@GetMapping("/alldoctors")
	public List<Doctor> getDoctorList() {
		return doctorService.getDoctorList();
	}

	//working
	@DeleteMapping("/removedoctor")
	@ExceptionHandler(DoctorException.class)
	public Doctor removeDoctor(@RequestBody Doctor doctor) {
		return doctorService.removeDoctor(doctor);
	}

	//working
	@PutMapping("/updatedoctor")
	@ExceptionHandler(DoctorException.class)
	public Doctor updateDoctorProfile(@RequestBody Doctor doctor) {
		return doctorService.updateDoctorProfile(doctor);
	}

	
	//working
	@GetMapping("/getdoctor/{doctorId}")
	//@ExceptionHandler(DoctorException.class)
	public Doctor getDoctor(@PathVariable("doctorId") Doctor doc) {
		return doctorService.getDoctor(doc);
	}
	
	//working
	@GetMapping("/alldoctors/{speciality}")
	@ExceptionHandler(DoctorException.class)
	public List<Doctor> getDoctorList(@PathVariable("speciality") String speciality) {
		return doctorService.getDoctorList(speciality);
	}
	
	//working
	@PostMapping("/addavailability")
	public boolean addAvailability(@RequestBody AvailabilityDates bean) {
		return doctorService.addAvailability(bean);
	}

	
	//working
	@PutMapping("/updateavailability")
	public boolean updateAvailability(@RequestBody AvailabilityDates availDates) {
		return doctorService.updateAvailability(availDates);
	}

	

	
}