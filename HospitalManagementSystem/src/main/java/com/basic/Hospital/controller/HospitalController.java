package com.basic.Hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.Hospital.dto.HospitalDto;
import com.basic.Hospital.services.HospitalServices;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/Hospitals")
public class HospitalController {

	@Autowired
	HospitalServices hospitalServices;
	
	@PostMapping("/saveHospitalDetails")
	public ResponseEntity<HospitalDto> postMethodName(@RequestBody HospitalDto hospitalDto) {
		HospitalDto hospital = hospitalServices.saveHospitalDetails(hospitalDto);
		return new ResponseEntity<>(hospital, HttpStatus.CREATED);
	}
	
	@GetMapping("/readAllHospitlaDetails")
	public ResponseEntity<List<HospitalDto>> getMethodName() {
		List<HospitalDto> readDetails = hospitalServices.readAllData();
		return new ResponseEntity<List<HospitalDto>>(readDetails, HttpStatus.OK);
	}
	
	@GetMapping("/readHospitalDetailsById/{id}")
	public ResponseEntity<HospitalDto> getMethodName(@PathVariable  Long id ) {
		HospitalDto readSpecific = hospitalServices.readDetailById(id);
		return new ResponseEntity<>(readSpecific, HttpStatus.OK);
	}
	
	@PutMapping("/updateHospitalDetails/{id}")
	public ResponseEntity<HospitalDto> putMethodName(@PathVariable Long id, @RequestBody HospitalDto hospitalDto) {
		HospitalDto updateHospital = hospitalServices.updateHospitalDetails(id, hospitalDto);
		return new ResponseEntity<>(updateHospital, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteHospitalDetails/{id}")
	public ResponseEntity<HospitalDto> deleteHospital(@PathVariable Long id){
		HospitalDto deleteDetails = hospitalServices.deleteHospitalDetail(id);
		return new ResponseEntity<>(deleteDetails, HttpStatus.OK);
	}
	
}

