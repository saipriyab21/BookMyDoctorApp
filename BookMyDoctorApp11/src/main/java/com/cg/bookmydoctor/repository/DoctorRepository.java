package com.cg.bookmydoctor.repository; 

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookmydoctor.dto.AvailabilityDates;
import com.cg.bookmydoctor.dto.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	List<Doctor> findBySpeciality(String special);

	void saveAvailabilityDates(AvailabilityDates bean);
}