package com.basic.Hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.Hospital.dto.PatientDto;
import com.basic.Hospital.services.PatientServices;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/Patients")
public class PatientController {

	@Autowired
	PatientServices patientServices;
	
	@PostMapping("/savePatientDetails")
	public ResponseEntity<PatientDto> postMethodName(@RequestBody PatientDto entity) {
		PatientDto patient = patientServices.savePatientData(entity);
		return new  ResponseEntity<>(patient, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/readAllpatients")
	public ResponseEntity<List<PatientDto>> getMethodName() {
		List<PatientDto> patientDto = patientServices.readAllPatientDetails();
		return new ResponseEntity<>(patientDto, HttpStatus.OK);
	}
	
	@GetMapping("/readPatientDetailsById/{id}")
	public ResponseEntity<PatientDto> getMethodName(@PathVariable Long id) {
		PatientDto readPatient = patientServices.readDetails(id);
		return new ResponseEntity<>(readPatient, HttpStatus.OK);
	}
	
	@PutMapping("/updatePatientDetails/{id}")
	public ResponseEntity<PatientDto> putMethodName(@PathVariable Long id, @RequestBody PatientDto entity) {
		PatientDto updatePatient = patientServices.updatePatientDetails(id, entity);
		return new ResponseEntity<>(updatePatient, HttpStatus.OK) ;
	}
	
	@DeleteMapping("/DeleteDetails/{id}")
	public ResponseEntity<PatientDto> deleteDetails(@PathVariable Long id){
		PatientDto deletePatientDetails = patientServices.deletePatientDetails(id);
		return new ResponseEntity<>(deletePatientDetails, HttpStatus.OK);
	}
}
