package com.cg.bookmydoctor.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;

public interface IFeedbackDao extends CrudRepository<FeedBack, Integer> {

	FeedBack findByDoctor(Optional<Doctor> optional);

	//Optional<FeedBack> findBydoctorId(int doctorId);

	/*public FeedBack addFeedback(FeedBack fdb);
	public FeedBack getFeedback(FeedBack fdb);
	public List<FeedBack> getAllFeedback(Doctor doc);*/
	
	
}
