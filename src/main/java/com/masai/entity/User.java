package com.masai.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;



import lombok.Data;

@Data
@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
	
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
	

	
	@Pattern(regexp = "[A-Za-z0-9@]{6,12}",message = "Password must be 6 to 15 characters and must have at least 1 alphabate and 1 number")
	private String Password;

	@NotBlank
	@NotNull
    private Integer coordinateX;
	
	@NotBlank
	@NotNull
    private Integer coordinateY;
}
