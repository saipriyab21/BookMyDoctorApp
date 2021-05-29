package com.cg.bookmydoctor.controller;

import java.math.BigInteger; 
import java.util.List;
import java.util.Optional;

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

import com.cg.bookmydoctor.dao.IDoctorDao;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;
import com.cg.bookmydoctor.exception.FeedBackException;
import com.cg.bookmydoctor.serviceImpl.FeedbackServiceImpl;

//@CrossOrigin("http://localhost:3500")
@RestController
@RequestMapping("/feedback")
public class FeedBackController {
	
	IDoctorDao docDao;
	@Autowired(required = true)
	FeedbackServiceImpl feedbackService;


	@RequestMapping("/allfeedbackofdoctor/{doctorId}")
	@ExceptionHandler(FeedBackException.class)
	public List<FeedBack> getAllFeedBack(@PathVariable("doctorId")Doctor doc) {
		//Optional<Doctor> docDb = docDao.findById(doctorId);
//		return feedbackService.getAllFeedback(docDb.get());
		return feedbackService.getAllFeedback(doc);
	}

	//working
	@PostMapping("/addfeedback")
	@ExceptionHandler(FeedBackException.class)
	public FeedBack addFeedback(@RequestBody FeedBack fdb) {
		return feedbackService.addFeedback(fdb);
	}

	//working
	@GetMapping("/getfeedback/{ratingId}")
	@ExceptionHandler(FeedBackException.class)
	public FeedBack getFeedback(@PathVariable("ratingId") FeedBack fdb) {
		return feedbackService.getFeedback(fdb);
	}
	
}
