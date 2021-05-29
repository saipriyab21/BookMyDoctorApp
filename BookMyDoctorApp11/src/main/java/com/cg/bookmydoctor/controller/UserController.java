package com.cg.bookmydoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.User;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.exception.UserException;
import com.cg.bookmydoctor.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceImpl userService ;

	
	//working
	@PostMapping("/adduser")
	@ExceptionHandler(UserException.class)
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	
	//working
	@PutMapping("/updateuser")
	@ExceptionHandler(UserException.class)
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	
	//working
	@DeleteMapping("/removeuser")
	@ExceptionHandler(AdminException.class)
	public User removeUser(@RequestBody User user) {
		return userService.removeUser(user);
	}
}
