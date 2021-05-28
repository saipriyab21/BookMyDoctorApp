package com.cg.bookmydoctor.service;
import java.util.ArrayList; 
import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.dao.IDoctorDao;
import com.cg.bookmydoctor.dao.IFeedbackDao;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.exception.FeedBackException;
import com.cg.bookmydoctor.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService { 

	IDoctorDao docDao;
	@Autowired
	private IFeedbackDao fbDao;
	FeedBack fb = new FeedBack();

	@Override
	public FeedBack addFeedback(FeedBack fdb) throws FeedBackException {
		Optional<FeedBack> findById = fbDao.findById(fdb.getFeedbackId());
		if(!findById.isPresent()) {
			return fbDao.save(fdb);
		}  else {
			throw new FeedBackException("Feedback with id : " +fdb.getFeedbackId()+ "already exists");
		}

	}

	@Override
	public FeedBack getFeedback(FeedBack fdb) throws FeedBackException {
		Optional<FeedBack> feedbackDB = fbDao.findById(fdb.getFeedbackId());
		if(feedbackDB.isPresent()) {
			return feedbackDB.get();
		} else {
			throw new FeedBackException("Feedback with ID : " +fdb.getFeedbackId()+"doesn't exist");
		}
	}

	@Override
	public List<FeedBack> getAllFeedback(Doctor doc) throws FeedBackException {
		Optional<Doctor> docDb = docDao.findById(doc.getDoctorId());
		List<FeedBack> list = new ArrayList<>();
		if(docDb.isPresent()) {
			list.add(fbDao.findByDoctor((docDb)));
		} else {
			throw new FeedBackException("Doctor with ID : " +doc.getDoctorId()+" doesn't exist"); 
		}
		return list;
	}
}