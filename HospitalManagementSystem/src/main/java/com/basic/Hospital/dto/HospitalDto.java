package com.basic.Hospital.dto;

import java.util.List;

import lombok.Data;

@Data
public class HospitalDto {

	private Long id;
	private String hospitalName;
	private String hospitalLocation;
	private String contactNumber;
	
	private List<PatientDto> patient;
	private List<DoctorDto> doctor;
	 
}
