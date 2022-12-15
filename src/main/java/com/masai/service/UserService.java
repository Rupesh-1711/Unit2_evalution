package com.masai.service;

import java.util.List;

import com.masai.entity.Driver;
import com.masai.entity.LoginDTO;
import com.masai.entity.User;
import com.masai.exceptions.DriverException;
import com.masai.exceptions.UserException;

public interface UserService {

	public String registerUser(User user) throws UserException;
	
	public String loginUser(LoginDTO dto) throws UserException;
	
	public User UdpateUser(User user,String key) throws UserException;
	
	public List<Driver> findByRide(Integer userId) throws UserException,DriverException;
	
	public String bookRide(Integer driverId,Integer userId,Integer x,Integer y)throws UserException,DriverException;
	
   
    Double calculateDist(Integer xUser, Integer yUser, Integer xCab, Integer yCab) throws UserException, DriverException;

}
