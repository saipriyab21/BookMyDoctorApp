package com.cg.bookmydoctor.service;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.dao.IUserDao;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.exception.UserException;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> findById = userDao.findById(user.getUserId());
		if(findById.isPresent()) {
			return userDao.save(user);
		} else if(findById.isEmpty()){
			throw new UserException("Passed object can't be null");
		} else {
			throw new UserException("Object not found");
		}
	}

	@Override
	public User updateUser(User user) {
		Optional<User> findById = userDao.findById(user.getUserId());
		if(findById.isPresent()) {
			return userDao.save(user);
		} else if(findById.isEmpty()){
			throw new UserException("Passed object can't be null");
		} else {
			throw new UserException("Object not found");
		}
	}

	@Override
	public User removeUser(User user) {
		User user1 = user;
		Optional<User> userdb = userDao.findById(user.getUserId());
		if(userdb.isPresent()) {
			userDao.delete(user);	

		} else {
			throw new UserException("The passed object can't be null");
		}
		return user1;
	}

}
