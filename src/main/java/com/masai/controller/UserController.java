package com.masai.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.LoginDTO;
import com.masai.entity.User;
import com.masai.exceptions.UserException;
import com.masai.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/masaicab/user")
public class UserController {

	
	@Autowired
	UserService uService;


	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@Valid @RequestBody User user) throws UserException {
	 String message = uService.registerUser(user);
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}

   @PostMapping("/login")
	public ResponseEntity<String> loginUser(LoginDTO dto) throws UserException {
		// TODO Auto-generated method stub
		String message = uService.loginUser(dto);
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}




	
}
