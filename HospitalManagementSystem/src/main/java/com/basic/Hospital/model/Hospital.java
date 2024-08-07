package com.basic.Hospital.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Hospital")
@Data
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "hospitalName")
	private String hospitalName;
	
	@Column(name = "hospitalLocation")
	private String hospitalLocation;
	
	@Column(name = "contactNumber")
	private String contactNumber;
	
	@OneToMany(mappedBy = "hospital")
	private List<Doctor>doctors;
	
	@OneToMany(mappedBy = "hospital")
	private List<Patient> patients;
	
	
}
