    package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.dao.CustomerDao;
import com.masai.dao.SessionDao;
import com.masai.exceptions.CustomerException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao cRepo;
	
	@Autowired
	private SessionDao sRepo;
	
	
	@Override
	public Customer createCustomer(Customer customer)throws CustomerException {
		
		
		Customer existingCustomer= cRepo.findByMobileNo(customer.getMobileNo());
		
		
		
		if(existingCustomer != null) 
			throw new CustomerException("Customer Already Registered with Mobile number");
			
		
		
		
			return cRepo.save(customer);
			
			
		}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException{
	
		CurrentUserSession loggedInUser= sRepo.findByUuid(key);
	
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		
		
	
		
		if(customer.getCustomerId() == loggedInUser.getUserId()) {
			//If LoggedInUser id is same as the id of supplied Customer which we want to update
			return cRepo.save(customer);
		}
		else
			throw new CustomerException("Invalid Customer Details, please login first");
	
	}
		
		
	}


