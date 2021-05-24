package com.cg.bookmydoctor.service;



import java.util.ArrayList;   
import java.util.List;      
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.DoctorException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookmydoctor.dao.*;
import com.cg.bookmydoctor.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorDao docDao;

	@Override
	public List<Doctor> getDoctorList(String speciality) {
		Optional<Doctor> findById = docDao.findById(speciality);
		List<Doctor> doclist =  null;
		if (findById.isPresent()) {
			doclist.add(findById.get());
		} else
			throw new DoctorException("Doctor with the speciality : " + speciality + "not exists");

		return doclist;
	}


	//all the details doctors
	@Override
	public List<Doctor> getDoctorList() {
		Iterable<Doctor> result = docDao.findAll();
		List<Doctor> resultList = new ArrayList<>();
		result.forEach(resultList :: add);
		return resultList;
	}
	

	@Override
	public Doctor addDoctor(Doctor dr) {
		Optional<Doctor> findById = docDao.findById(dr.getDoctorId());
		if(findById.isPresent()) {
			return docDao.save(dr);
		} else if(findById.isEmpty()){
			throw new DoctorException("Passed object can't be null");
		} else {
			throw new DoctorException("Object not found");
		}
	}

	public boolean updateAvailability(AvailabilityDates bean) {
		if(bean.getAvailabilityId() == ad.getAvailabilityId()) {
			ad.setAvailabilityId(bean.getAvailabilityId());
			ad.setDoctor(bean.getDoctor());
			ad.setFromDate(bean.getFromDate());
			ad.setToDate(bean.getToDate());
			return true;		
		} else {
			//throw new DoctorException("Couldn't update availability dates");
			return false;
		}
	}


	private AvailabilityDates ad;


	@Override
	public Doctor removeDoctor(Doctor doc) {
		Doctor dr = doc;
		Optional<Doctor> docdb = docDao.findById(doc.getDoctorId());
		if(docdb.isPresent()) {
			docDao.delete(doc);	

		} else {
			throw new DoctorException("The passed object can't be null");
		}
		return dr;
	}

	public Doctor getDoctor(Doctor doc) {
		Optional<Doctor> docdb = docDao.findById(doc.getDoctorId());

		if(docdb.isPresent()) {
			return docdb.get();
		} 
		else {
			throw new DoctorException("Record not found with id : " + doc.getDoctorId());
		}

	}


	public boolean addAvailability(AvailabilityDates bean) {
		if(bean != null) {
			docDao.save(bean);
			return true;
		}	
		return false;
	}


	@Override
	public Doctor updateDoctorProfile(Doctor bean) {
		// TODO Auto-generated method stub
		Optional<Doctor> findById = docDao.findById(bean.getDoctorId());
		if (findById.isPresent()) {
			docDao.save(bean);
		} 
		else
			throw new DoctorException("Doctor with ID: " + bean.getDoctorId() + "does not exists");
		return bean;

	} 

}


