package com.basic.Hospital.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.Hospital.ExceptionHandler.IdNotFoundException;
import com.basic.Hospital.dto.DoctorDto;
import com.basic.Hospital.model.Doctor;
import com.basic.Hospital.repository.DoctorRepository;
import com.basic.Hospital.services.DoctorServices;

@Service
public class DoctorServiceImpl implements DoctorServices{

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public DoctorDto saveDoctorinformation(DoctorDto entity) {
		
		Doctor doctor = modelMapper.map(entity, Doctor.class);
		
		Doctor savedDoctor = doctorRepository.save(doctor);
		
		return modelMapper.map(savedDoctor, DoctorDto.class );
	}

	@Override
	public List<DoctorDto> readAllDoctors() {
		List<Doctor> doctors = doctorRepository.findAll();
		List<DoctorDto> doctorDtos = new ArrayList<DoctorDto>();
		for(Doctor doc : doctors) {
			doctorDtos.add(modelMapper.map(doc, DoctorDto.class));
		}
		return doctorDtos;
	}

	@Override
	public DoctorDto readDetailById(Long id) {
		Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
		return modelMapper.map(doctor, DoctorDto.class);
	}

	@Override
	public DoctorDto updateDoctorDetails(Long id, DoctorDto doctorDto) {
		Doctor existingDetails = doctorRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
		
		existingDetails.setEmail(doctorDto.getEmail());
		existingDetails.setSpecialization(doctorDto.getSpecialization());
		
		Doctor updatedDetails = doctorRepository.save(existingDetails);
		return modelMapper.map(updatedDetails, DoctorDto.class);
	}

	@Override
	public DoctorDto deleteDetail(Long id) {
		Doctor doctor = this.doctorRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
		this.doctorRepository.deleteById(id);
		return null;
	}
	
	
	
}
