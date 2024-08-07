package com.basic.Hospital.services;

import java.util.List;

import com.basic.Hospital.dto.PatientDto;

public interface PatientServices {

	PatientDto savePatientData(PatientDto entity);

	List<PatientDto> readAllPatientDetails();

	PatientDto readDetails(Long id);

	PatientDto updatePatientDetails(Long id, PatientDto entity);

	PatientDto deletePatientDetails(Long id);

}
