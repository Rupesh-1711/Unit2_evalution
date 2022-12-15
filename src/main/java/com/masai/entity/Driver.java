package com.masai.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Driver {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer driverId;
	@NotBlank
	@NotNull
	@Pattern(regexp = "[a-zA-Z]{2,12}", message = "First Name must not contain numbers or special characters")
	private String firstName;
	
	@NotBlank
	@NotNull
	@Pattern(regexp = "[a-zA-Z]{2,12}", message = "First Name must not contain numbers or special characters")
	private String lastName;
	
	@NotBlank
	@NotNull
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must have 10 digits")
    private String mobileNumber;
	
	@NotBlank
	@NotNull
    private String cabNumber;
	
	@NotEmpty(message = "Provide Coordinate-X and Coordinate-Y of User")
    private Integer[] coordinate;
	
	@NotNull
    Boolean booked;
	
	@OneToOne(mappedBy="user",cascade= CascadeType.ALL)
	private Cab cab;
}
