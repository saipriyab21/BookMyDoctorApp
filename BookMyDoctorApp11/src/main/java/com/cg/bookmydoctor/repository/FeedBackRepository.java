package com.cg.bookmydoctor.repository;

import java.util.List;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;

@Transactional(readOnly = true)
public interface FeedBackRepository extends JpaRepository<FeedBack, Integer>{
	
	
	@Transactional(timeout = 10)
	FeedBack getFeedback(FeedBack dr);
	
	@Transactional(timeout = 10)
	List<FeedBack> findAll();
	
	@Transactional
	<S extends FeedBack> S save(FeedBack dr);
	
	
}
