package com.cg.bookmydoctor.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any; 
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bookmydoctor.BookMyDoctorAppApplicationTests;
import com.cg.bookmydoctor.dao.IDoctorDao;
import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.serviceImpl.DoctorServiceImpl;


@SpringBootTest
public class DoctorApplicationTesting extends BookMyDoctorAppApplicationTests {

	@Autowired
	private DoctorServiceImpl docservice;

	@Autowired
	private IDoctorDao docDao;

	@Test
	void testdoctorServiceImpl() {
		assertTrue(docservice instanceof DoctorServiceImpl);
	}


	@Test
	void testAddDoctor() {
		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Mumbai Hospital","8787778866", "priyaeee@gmail.com","Joshi!123", 800);
		doctor = docservice.addDoctor(doctor);
		assertEquals(doctor.getDoctorName(), "K Priya");
		
		Doctor doctor2 = new Doctor(2,"M Harhsitha", "ENT", "Agra Delhi", "Sunshine Hospital", "9000878787","harshitha@gmail.com", "Crafty21!", 800);
		doctor2 = docservice.addDoctor(doctor2);
		assertEquals(doctor2.getDoctorName(), "M Harhsitha");
	}
	@Test
	void testEditDoctor()  {
		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Shivaji Hospital","8787778866", "priyaeee@gmail.com","Joshi!123", 800);
		doctor = docservice.updateDoctorProfile(doctor);
		assertEquals(doctor.getHospitalName(), "Shivaji Hospital");
	}
	
	@Test
	void testRemovedoctor() {
		Doctor doctor = docDao.findById(2).get();
		Doctor deletedDoctor = docservice.removeDoctor(doctor);
		assertEquals(deletedDoctor, doctor);
	}
	
	@Test
	void testGetDoctor() {
		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Shivaji Hospital","8787778866", "priyaeee@gmail.com","Joshi!123", 800);
		
		Doctor doctorGetter = docservice.getDoctor(doctor);
		assertNotNull(doctorGetter);
	}
	
	@Test 
	void testGetDoctorList() {
		
		List<Doctor> docList = docservice.getDoctorList();
		assertNotNull(docList);
	}
}
























	/*
	@Test
	void testDoctorSpecialityList() {
		List<Doctor> doctorList = docservice.getDoctorList("ENT");
		assertNotNull(doctorList);
	}
	
	@Test
	void testAddAvailability() {
		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Shivaji Hospital","8787778866", "priyaeee@gmail.com","Joshi!123", 800);
		//doctor = docservice.addDoctor(doctor);
		AvailabilityDates availDates = new AvailabilityDates(4, doctor, LocalDate.of(2021, 06,13), LocalDate.of(2021, 06, 20));
		boolean availDatesRes = docservice.addAvailability(availDates);
		assertEquals(availDatesRes, true);
	}
	
		/*Doctor doctor2 = new Doctor(2,"M Harhsitha", "ENT", "Agra Delhi", "Sunshine Hospital", "9000878787","harshitha@gmail.com", "Crafty21!", 800);
		doctor2 = docservice.addDoctor(doctor2);
		assertEquals(doctor2.getDoctorName(), "M Harhsitha");
	}
	
	
	@Test
	void testEditAvailability()  {
		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Shivaji Hospital","8787778866", "priyaeee@gmail.com","Joshi!123", 800);
		doctor = docservice.updateDoctorProfile(doctor);
		assertEquals(doctor.getHospitalName(), "Shivaji Hospital");
	}
	
	*/

