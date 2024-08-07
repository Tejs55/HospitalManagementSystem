package com.basic.Hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "doctor")
@Data
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "specialization")
	private String specialization;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;

}
