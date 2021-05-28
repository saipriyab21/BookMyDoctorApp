package com.cg.bookmydoctor;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.bookmydoctor.dao.IFeedbackDao;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;
import com.cg.bookmydoctor.dto.Patient;

@SpringBootApplication
public class BookMyDoctorAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookMyDoctorAppApplication.class, args);
	}
	/*
	private IFeedbackDao fbDao;
	public void run(String args) throws Exception {
		FeedBack feedback = new FeedBack();
		 
		Doctor doctor = new Doctor();
		
		Patient patient = new Patient();
		feedback.setDoctor(doctor);
		
		feedback.setPatient(patient);
		
		fbDao.save(feedback);
	}*/
}