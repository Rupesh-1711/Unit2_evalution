package com.masai.service;

import com.masai.entity.Driver;
import com.masai.entity.User;
import com.masai.exceptions.DriverException;
import com.masai.exceptions.UserException;

public interface DriverService {

	public String registerUser(Driver driver) throws DriverException,DriverException;
	
}
