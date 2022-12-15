package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.CurrentDriverSession;


public interface SessionDriverDao extends JpaRepository<CurrentDriverSession, String>{

	Optional<CurrentDriverSession> findByMobileNumber(String mobileNumber);

	Optional<CurrentDriverSession> findByUserId(Integer driverId);
	public  CurrentDriverSession  findByUuid(String uuid);
}
