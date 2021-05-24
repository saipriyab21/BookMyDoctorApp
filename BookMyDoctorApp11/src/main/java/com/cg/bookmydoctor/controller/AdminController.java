package com.cg.bookmydoctor.controller;


import java.math.BigInteger; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.service.AdminServiceImpl;


@CrossOrigin("http://localhost:3500")
@RestController
@RequestMapping("/doctorappointments")
public class AdminController {
	@Autowired(required = true)
	AdminServiceImpl adminservice ;

	@GetMapping("/viewAdmin")
	@ExceptionHandler(AdminException.class)
	public Admin viewAirport(@RequestBody Admin Admin) {
		return adminservice.viewAdmin(Admin);
	}


	@PostMapping("/addAdmin")
	@ExceptionHandler(AdminException.class)
	public Admin addAdmin(@RequestBody Admin Admin) {
		return adminservice.addAdmin(Admin);
	}

	@PutMapping("/updateAdmin")
	@ExceptionHandler(AdminException.class)
	public Admin updateAdmin(@RequestBody Admin Admin) {
		return adminservice.updateAdmin(Admin);
	}

	@DeleteMapping("/removeAdmin")
	@ExceptionHandler(AdminException.class)
	public Admin removeAdmin(@RequestBody Admin Admin) {
		return adminservice.removeAdmin(Admin);
	}
}
