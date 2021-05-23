package com.cg.bookmydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.bookmydoctor.dto.FeedBack;

public interface FeedBackRepository extends JpaRepository<FeedBack, Integer>{
	
}
