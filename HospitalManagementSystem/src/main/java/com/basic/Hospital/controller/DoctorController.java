package com.basic.Hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.Hospital.dto.DoctorDto;
import com.basic.Hospital.services.DoctorServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/Doctors")
public class DoctorController {

	@Autowired
	DoctorServices doctorServices;
	
	@PostMapping("/saveDoctorDetails")
	public ResponseEntity<DoctorDto> postDoctors(@RequestBody DoctorDto entity) {
		DoctorDto doctor = doctorServices.saveDoctorinformation(entity);
		return new ResponseEntity<>(doctor, HttpStatus.CREATED);
	}
	
	@GetMapping("/readAllDoctorDetails")
	public ResponseEntity<List<DoctorDto>> getMethodName() {
		List<DoctorDto> doctorDto  = doctorServices.readAllDoctors();
		return new ResponseEntity<>(doctorDto, HttpStatus.OK);
	}
	
	@GetMapping("/readDoctorDetailsById/{id}")
	public ResponseEntity<DoctorDto> getMethodName(@PathVariable Long id) {
		DoctorDto doctorDto = doctorServices.readDetailById(id);
		return new ResponseEntity<>(doctorDto, HttpStatus.OK);
	}
	
	@PutMapping("/updateDoctorDetails/{id}")
	public ResponseEntity<DoctorDto> putMethodName(@PathVariable Long id, @RequestBody DoctorDto doctorDto) {
		DoctorDto doctor = doctorServices.updateDoctorDetails(id, doctorDto);
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteDoctorDetails/{id}")
	public ResponseEntity<DoctorDto> deleteDetails(@PathVariable Long id){
		DoctorDto doctorDto = doctorServices.deleteDetail(id);
		return new ResponseEntity<>(doctorDto, HttpStatus.OK);
	}
	

}
