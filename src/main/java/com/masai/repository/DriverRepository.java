package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
