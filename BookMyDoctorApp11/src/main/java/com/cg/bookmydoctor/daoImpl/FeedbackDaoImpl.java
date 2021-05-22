package com.cg.bookmydoctor.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookmydoctor.dao.IFeedbackDao;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;
import com.cg.bookmydoctor.repository.DoctorRepository;
import com.cg.bookmydoctor.repository.FeedBackRepository;

public class FeedbackDaoImpl implements IFeedbackDao {

	private static final Logger logger = LoggerFactory.getLogger(FeedbackDaoImpl.class);

	@Autowired
	private FeedBackRepository fbrep;

	public FeedbackDaoImpl() {  	 }
	
	public FeedBack addFeedback(FeedBack fdb) {
		
		try {
			fbrep.save(fdb);
			return fbrep.getOne(fdb);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	
	public FeedBack getFeedback(FeedBack fbr) {
		
		try {
			return fbrep.getOne(fbr);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	
	public List<FeedBack> getAllFeedback(Doctor doc) {
		try {
			List<FeedBack> list = new ArrayList<>();
			List<FeedBack> result = fbrep.findAll();
			for (FeedBack fb : result) {
				list.add(fb);
			}
			return list;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
