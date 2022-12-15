package com.masai.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.entity.Driver;
import com.masai.entity.User;
import com.masai.exceptions.DriverException;
import com.masai.exceptions.UserException;
import com.masai.repository.DriverRepository;
import com.masai.repository.SessionDao;
import com.masai.repository.SessionDriverDao;
import com.masai.repository.UserRepository;
import com.masai.service.DriverService;

public class DriverServicerImpl implements DriverService{

	@Autowired
	UserRepository uRepo;
	
	@Autowired
    DriverRepository dRepo;
	

	
	@Override
	public String registerUser(Driver driver) throws DriverException {
		  Optional<User> ExistUser = uRepo.findByMobileNumber(driver.getMobileNumber());
			
			if(ExistUser.isPresent()) {
				throw new DriverException("Driver  already present ");
			}
			
			dRepo.save(driver);
			  
			return "Driver Register successfully";
	}
	

}
