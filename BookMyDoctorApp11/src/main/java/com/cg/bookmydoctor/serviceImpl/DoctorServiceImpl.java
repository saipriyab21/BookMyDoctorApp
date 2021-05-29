package com.cg.bookmydoctor.serviceImpl;





import java.util.ArrayList;   
import java.util.List;      
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.service.IDoctorService;
import com.cg.bookmydoctor.constants.DoctorConstants;
import com.cg.bookmydoctor.dao.*;


@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorDao docDao;
	Doctor doctor;
	@Autowired
	private IAvailabilityDao availDao;
	//AvailabilityDates availDates;

	//all the details doctors
	//working
	@Override
	public List<Doctor> getDoctorList() {
		Iterable<Doctor> result = docDao.findAll();
		List<Doctor> resultList = new ArrayList<>();
		result.forEach(resultList :: add);
		return resultList;
	}

	//working
	@Override
	public Doctor addDoctor(Doctor dr) throws DoctorException {
		validateDoctor(dr);
		Optional<Doctor> findById = docDao.findById(dr.getDoctorId());
		if(findById.isPresent()) {
			throw new DoctorException("Doctor object already exists with ID : " +dr.getDoctorId());
		} else {
			return docDao.save(dr);
		}
	}

	//working
	@Override
	public Doctor updateDoctorProfile(Doctor bean) throws DoctorException {
		validateDoctor(bean);
		// TODO Auto-generated method stub
		Optional<Doctor> findById = docDao.findById(bean.getDoctorId());
		if(!findById.isPresent()) {
			throw new DoctorException("Doctor doesn't exist with ID : " +bean.getDoctorId());
		} else {
			return docDao.save(bean);
		}
	}


	//working
	@Override
	public Doctor removeDoctor(Doctor doc) throws DoctorException {
		Doctor dr = doc;
		Optional<Doctor> docdb = docDao.findById(doc.getDoctorId());
		if(!docdb.isPresent()) {
			throw new DoctorException("Doctor with id : " +doc.getDoctorId() +"doesn't exist to delete");

		} else {
			docDao.deleteById(doc.getDoctorId());	
		}
		return dr;
	}


	//working
	public Doctor getDoctor(Doctor doc) throws DoctorException {
		Optional<Doctor> docdb = docDao.findById(doc.getDoctorId());
		if(docdb.isPresent()) {
			return docdb.get();
		} else {
			return null;
		}

	}


	//working
	@Override
	public List<Doctor> getDoctorList(String speciality) throws DoctorException {

		Optional<Doctor> findById = docDao.findBySpeciality(speciality);
		List<Doctor> doclist = new ArrayList<>();
		if (findById.isPresent()) {
			doclist.add(findById.get());
		} else
			throw new DoctorException("Doctor with the speciality : " + speciality + "not exists");

		return doclist;
	}



	//private AvailabilityDates ad;
	//working
	public boolean addAvailability(AvailabilityDates availDates) {
		if(availDates != null) {
			Optional<AvailabilityDates> findById = availDao.findById(availDates.getAvailabilityId());
			if(! findById.isPresent()) {
				//if(doctor.getDoctorId() ==  bean.getDoctor().getDoctorId()) {
				availDao.save(availDates);
				return true;
			}

		}	
		return false;
	}

	//AvailabilityDates availdates1;
	public boolean updateAvailability(AvailabilityDates availDates) {
		//if(availabilityId > 0) {
		Optional<AvailabilityDates> findById = availDao.findById(availDates.getAvailabilityId());
		if(findById.isPresent()) {
			availDao.save(availDates);
			return true;	

		} else {
			return false;
		}
	}


	public boolean validateDoctor(Doctor doctor) throws DoctorException {

		if(!doctor.getDoctorName().matches("([A-Za-z])|([a-zA-Z]+[ ]{1}[a-zA-Z]+)")) {
			throw new DoctorException(DoctorConstants.NAME_CANNOT_BE_EMPTY);
		}
		if(!doctor.getEmail().matches("[A-Za-z0-9+_.-]+@(.+)$")) {
			throw new DoctorException(DoctorConstants.EMAIL_CANNOT_BE_EMPTY);
		}
		if(!doctor.getHospitalName().matches("([A-Za-z])|([a-zA-Z]+[ ]{1}[a-zA-Z]+)")) {
			throw new DoctorException(DoctorConstants.HOSPITALNAME_CANNOT_BE_EMPTY);
		}
		if(!doctor.getLocation().matches("([A-Za-z])|([a-zA-Z]+[ ]{1}[a-zA-Z]+)")) {
			throw new DoctorException(DoctorConstants.LOCATION_CANNOT_BE_EMPTY);
		}
		if(!doctor.getMobileNo().matches("(0/91)?[7-9][0-9]{9}")) {
			throw new DoctorException(DoctorConstants.MOBILE_NUMBER_CANNOT_BE_EMPTY);
		}
		if(!doctor.getPassword().matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$")) {
			throw new DoctorException(DoctorConstants.PASSWORD_CANNOT_BE_EMPTY);
		}
		if(!doctor.getSpeciality().matches("([A-Za-z])|([a-zA-Z]+)")) {
			throw new DoctorException(DoctorConstants.SPECIALITY_CANNOT_BE_EMPTY);
		}
		return true;
	}

}
