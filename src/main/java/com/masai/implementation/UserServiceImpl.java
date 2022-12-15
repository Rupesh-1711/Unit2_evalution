package com.masai.implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.CurrentUserSession;
import com.masai.entity.Driver;
import com.masai.entity.LoginDTO;

import com.masai.entity.User;
import com.masai.exceptions.DriverException;
import com.masai.exceptions.UserException;
import com.masai.repository.DriverRepository;
import com.masai.repository.SessionDao;
import com.masai.repository.UserRepository;
import com.masai.service.UserService;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository uRepo;
	
	@Autowired
    DriverRepository dRepo;
	
	@Autowired
	private SessionDao sDao;
	
	@Override
	public String registerUser(User user) throws UserException {
      Optional<User> ExistUser = uRepo.findByMobileNumber(user.getMobileNumber());
		
		if(ExistUser.isPresent()) {
			throw new UserException("User  already present ");
		}
		
		uRepo.save(user);
		  
		return "User Register successfully";
	}

	@Override
	public String loginUser(LoginDTO dto) throws UserException {
	Optional<User> ExistUser = uRepo.findByMobileNumber(dto.getMobileNumber());
		
		if(ExistUser == null) {
			
			throw new UserException("Please Enter a Email");
			
			 
		}
		
		Optional<CurrentUserSession> validUserSessionOpt =  sDao.findByMobileNumber(ExistUser.get().getMobileNumber());;
		

		
		if(validUserSessionOpt.isPresent()) {
			
			throw new UserException("User already Logged In with this number");
			
		}
		
		if(ExistUser.get().getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			
			CurrentUserSession currentUserSession = new CurrentUserSession(ExistUser.get().getMobileNumber(),key,LocalDateTime.now());
			
			sDao.save(currentUserSession);

			return currentUserSession.toString();
		}
		else {
			throw new UserException("Please Enter a valid password");
		}
			
		
	}

	@Override
	public User UdpateUser(User user, String key) throws UserException {
		CurrentUserSession loggedInUser= sDao.findByUuid(key);
		
		if(loggedInUser == null){
			throw new UserException("Please provide a valid key to update a User");
		}
		
		
		if(user.getMobileNumber() == loggedInUser.getMobileNumber()) {
			
			return uRepo.save(user);
		}
		else {
			throw new UserException("Invalid Customer Details, please login first");
		}
	}



	@Override
	public String bookRide(Integer driverId, Integer x, Integer y) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calculateDist(Integer xUser, Integer yUser, Integer xCab, Integer yCab)
			throws UserException, DriverException {
        if(xUser == null && yUser == null) {
        	throw new UserException("Provide Valid User-Coordinates");
        }
            
        if(xCab == null && xCab == null) {
        	throw new DriverException("Provide Valid Driver-Coordinated");
        }
            
        return Math.pow(Math.pow(((double)xUser - (double)xCab), 2) + Math.pow(((double)yUser - (double)yCab), 2), (double)1/2);
	}

	@Override
	public List<Driver> findByRide(Integer userId) throws UserException {
		Optional<User> userOpt = uRepo.findById(userId);
      if(userOpt.isEmpty())
          throw new UserException("Invalid User : Please login again.");
      User user = userOpt.get();
      Integer coordinateUserX = user.getCoordinateX();
      Integer coordinateUserY = user.getCoordinateY();
      
      
		return null;
	}



	



}
