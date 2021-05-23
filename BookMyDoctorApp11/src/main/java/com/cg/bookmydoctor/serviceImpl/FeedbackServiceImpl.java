package com.cg.bookmydoctor.serviceImpl;
import java.util.List;  
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.FeedBackException;
import com.cg.bookmydoctor.repository.FeedBackRepository;
import com.cg.bookmydoctor.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
	
	FeedBackRepository fbrep;


	@Override
	public FeedBack addFeedback(FeedBack fdb) {

		if (fdb == null) {
			throw new FeedBackException("The passed object cannot be null.");
		}
		return fbrep.save(fdb);

	}

	@Override
	public FeedBack getFeedback(FeedBack fdb) {
		Optional<FeedBack> fbdb = this.fbrep.findById(fdb.getRatingId());

		if(fbdb.isPresent()) {
			return fbdb.get();
		} 
		else {
			throw new FeedBackException("Record not found with id : " + fdb.getRatingId());
		}
		
	}
	
	@Override
	public List<FeedBack> getAllFeedback(Doctor doc) {
		List<FeedBack> result = fbrep.findAll();
		return result;

	}
}