package com.cg.bookmydoctor.serviceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.dao.IDoctorDao;
import com.cg.bookmydoctor.daoImpl.DoctorDaoImpl;
import com.cg.bookmydoctor.daoImpl.FeedbackDaoImpl;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
	@Autowired
	FeedbackDaoImpl fbimpl;


	@Override
	public FeedBack addFeedback(FeedBack fdb) {

		if (fdb == null) {
			throw new DoctorException("The passed object cannot be null.");
		}
		return fbimpl.addFeedback(fdb);

	}

	@Override
	public FeedBack getFeedback(FeedBack fdb) {
		if (fdb == null) {
			throw new DoctorException("The passed object cannot be null.");
		}
		return fbimpl.getFeedback(fdb);
	}
	
	@Override
	public List<FeedBack> getAllFeedback(Doctor doc) {
		return  fbimpl.getAllFeedback(doc);

	}
}