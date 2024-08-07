package com.basic.Hospital.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.Hospital.ExceptionHandler.IdNotFoundException;
import com.basic.Hospital.dto.PatientDto;
import com.basic.Hospital.model.Patient;
import com.basic.Hospital.repository.PatientRepository;
import com.basic.Hospital.services.PatientServices;

@Service
public class PatientServiceImpl implements PatientServices {

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	ModelMapper modelMapper;

	
	@Override
	public PatientDto savePatientData(PatientDto entity) {
		Patient patient = modelMapper.map(entity, Patient.class);
		Patient patients = patientRepository.save(patient);
		return modelMapper.map(patients, PatientDto.class );
	}
	

	@Override
	public List<PatientDto> readAllPatientDetails() {
		List<Patient>readPatient = patientRepository.findAll();
		List<PatientDto>readPatientDto = new ArrayList<PatientDto>();
		for(Patient patientObj : readPatient) {
			readPatientDto.add(modelMapper.map(patientObj, PatientDto.class));
		}
		return readPatientDto;
	}

	@Override
	public PatientDto readDetails(Long id) {
		Patient patient = patientRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
		return modelMapper.map(patient, PatientDto.class);
	}

	@Override
	public PatientDto updatePatientDetails(Long id, PatientDto entity) {
		Patient existingInfo = patientRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
		
		existingInfo.setName(entity.getName());
		existingInfo.setAddress(entity.getAddress());
		existingInfo.setMedicalHistory(entity.getMedicalHistory());
		
		Patient updatedInfo = patientRepository.save(existingInfo);
		return modelMapper.map(updatedInfo, PatientDto.class);
	}

	@Override
	public PatientDto deletePatientDetails(Long id) {
		Patient patient = this.patientRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
		this.patientRepository.deleteById(id);
		return null;
	}

	
	
	
}
