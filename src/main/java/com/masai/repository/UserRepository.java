package com.masai.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	


	Optional<User> findByUserId(Integer userId);

//	Optional<User> findByMobileNumber(String mobileNumber);

	Optional<User> findByMobileNumber(@NotNull String mobileNumber);
}
