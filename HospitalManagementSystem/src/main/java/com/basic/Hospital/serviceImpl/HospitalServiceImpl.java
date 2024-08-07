package com.basic.Hospital.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.Hospital.ExceptionHandler.IdNotFoundException;
import com.basic.Hospital.dto.HospitalDto;
import com.basic.Hospital.model.Hospital;
import com.basic.Hospital.repository.HospitalRepository;
import com.basic.Hospital.services.HospitalServices;

@Service
public class HospitalServiceImpl implements HospitalServices{

	@Autowired
	HospitalRepository hospitalRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public HospitalDto saveHospitalDetails(HospitalDto hospitalDto) {
		Hospital hospital = modelMapper.map(hospitalDto, Hospital.class);
		
		Hospital hospitals = hospitalRepository.save(hospital);
		
		return modelMapper.map(hospitals, HospitalDto.class);
	}

	@Override
	public List<HospitalDto> readAllData() {
		List<Hospital> hospital = hospitalRepository.findAll();
		List<HospitalDto>hospitalDtos = new ArrayList<HospitalDto>();
		for(Hospital hospitalObj : hospital) {
			hospitalDtos.add(modelMapper.map(hospitalObj, HospitalDto.class));
			
		}
		return hospitalDtos;
	}

	@Override
	public HospitalDto readDetailById(Long id) {
		Hospital hospital = hospitalRepository.findById(id).orElseThrow(()->new IdNotFoundException());
		return modelMapper.map(hospital, HospitalDto.class);
	}

	@Override
	public HospitalDto updateHospitalDetails(Long id, HospitalDto hospitalDto) {
		Hospital existingDetail = hospitalRepository.findById(id).orElseThrow(()-> new IdNotFoundException());
		
		existingDetail.setHospitalName(hospitalDto.getHospitalName());
		existingDetail.setContactNumber(hospitalDto.getContactNumber());
		
		Hospital updatedDetails = hospitalRepository.save(existingDetail);
		return modelMapper.map(updatedDetails, HospitalDto.class);
	}

	@Override
	public HospitalDto deleteHospitalDetail(Long id) {
		Hospital hospital = this.hospitalRepository.findById(id).orElseThrow(()->new IdNotFoundException());
		this.hospitalRepository.deleteById(id);
		return null;
	}
	
	
	
	
	
	
}
