package com.cg.bookmydoctor.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.dto.Appointment;
import com.cg.bookmydoctor.dto.Doctor;

public interface IAppointmentDao extends CrudRepository<Appointment, Integer>  {

	List<Appointment> findAllByAppointmentDate(LocalDate date);

	
	@Query("select appointment from Appointment appointment where appointment.doctor.doctorId = :id")
	List<Appointment> findAllByDoctorId(@Param("id") int doctorId);
	
	/*public List<Appointment> getAllAppointments();
	public Appointment getAppointment(int appointmentId);
	public boolean deleteAppointment(int appointmentId);
	public boolean updateAppointment(Appointment bean);
	public List<Appointment> getAppointments(Doctor doc);
	public List<Appointment> getAppointments(LocalDate doc);*/
	

}
