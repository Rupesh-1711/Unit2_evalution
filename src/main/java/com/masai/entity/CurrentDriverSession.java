package com.masai.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentDriverSession {

	@Id
	@Column(unique = true)
	private String mobileNumber;
	
	
	private String uuid;
	
	private LocalDateTime localDateTime;
}
