package com.masai.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Cab {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NonNull
	@NotBlank
	private String carBrand;
	
	@NonNull
	@NotBlank
	private Integer ratePerKm;

	@OneToOne
	@JsonIgnore
	private Driver driver;
	
	
}
