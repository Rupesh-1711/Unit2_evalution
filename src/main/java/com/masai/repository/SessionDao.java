package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.*;

@Repository
public interface SessionDao extends JpaRepository<CurrentUserSession, String> {

	Optional<CurrentUserSession> findByMobileNumber(String mobileNumber);

	Optional<CurrentUserSession> findByUserId(Integer userId);
	public  CurrentUserSession  findByUuid(String uuid);
}
