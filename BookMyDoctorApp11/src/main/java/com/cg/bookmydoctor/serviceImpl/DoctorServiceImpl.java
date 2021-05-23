package com.cg.bookmydoctor.serviceImpl;



import java.util.List;    
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.repository.DoctorRepository;
import com.cg.bookmydoctor.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {
	
	@Autowired
	private DoctorRepository docrep;
	private AvailabilityDates ad;
	
	@Override
	public List<Doctor> getDoctorList(String speciality) {
		return docrep.findBySpeciality(speciality);
	}
	
	
	//all the details doctors
	@Override
	public List<Doctor> getDoctorList() {
		List<Doctor> result = docrep.findAll();
		return result;
	}

	@Override
	public Doctor removeDoctor(Doctor doc) {
		if(doc==null) {
			throw new DoctorException("The passed object can't be null");
		}
		Doctor dr = doc;
		docrep.deleteById(doc.getDoctorId());
		return dr;
	}

	public Doctor getDoctor(Doctor doc) {
		Optional<Doctor> docdb = this.docrep.findById(doc.getDoctorId());

		if(docdb.isPresent()) {
			return docdb.get();
		} 
		else {
			throw new DoctorException("Record not found with id : " + doc.getDoctorId());
		}
		
	}
	
	@Override
	public Doctor updateDoctorProfile(Doctor bean) {
		Optional<Doctor> docdb = this.docrep.findById(bean.getDoctorId());

		if(docdb.isPresent()) {
			return docdb.get();
		} 
		else {
			throw new DoctorException("Record not found with id : " + bean.getDoctorId());
		}
	}

	@Override
	public Doctor addDoctor(Doctor dr) {
		
		return docrep.save(dr);
	}

	public boolean addAvailability(AvailabilityDates bean) {
		if(bean != null) {
			docrep.saveAvailabilityDates(bean);
			return true;
		}	
		return false;
	} 
	
	
	public boolean updateAvailability(AvailabilityDates bean) {
		if(bean.getAvailabilityId() == ad.getAvailabilityId()) {
			ad.setAvailabilityId(bean.getAvailabilityId());
			ad.setDoctor(bean.getDoctor());
			ad.setFromDate(bean.getFromDate());
			ad.setToDate(bean.getToDate());
			return true;		
		} 
		return false;
	}



}


