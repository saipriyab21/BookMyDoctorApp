package com.cg.bookmydoctor.repository;

import java.util.List;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;

@Transactional(readOnly = true)
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
	
	@Transactional(timeout = 10)
	List<Doctor> getById(String speciality);
	
	@Transactional(timeout = 10)
	Doctor getDoctor(Doctor dr);
	
	@Transactional(timeout = 10)
	List<Doctor> findAll();
	
	@Transactional
	<S extends Doctor> S save(Doctor dr);
	
	@Transactional
	<S extends AvailabilityDates> S saveDate(AvailabilityDates ad);
	
	void delete(Doctor dr);

		

	//void save(AvailabilityDates bean);
}