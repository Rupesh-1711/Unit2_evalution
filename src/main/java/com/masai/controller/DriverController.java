package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Driver;
import com.masai.exceptions.DriverException;
import com.masai.service.DriverService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/masaicab/driver")
public class DriverController {

	@Autowired
	private DriverService dService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Driver driver) throws DriverException {
		String message = dService.registerUser(driver);
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
}
