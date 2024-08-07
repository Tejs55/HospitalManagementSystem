package com.basic.Hospital.services;

import java.util.List;

import com.basic.Hospital.dto.HospitalDto;

public interface HospitalServices {

	HospitalDto saveHospitalDetails(HospitalDto hospitalDto);

	List<HospitalDto> readAllData();

	HospitalDto readDetailById(Long id);

	HospitalDto updateHospitalDetails(Long id, HospitalDto hospitalDto);

	HospitalDto deleteHospitalDetail(Long id);

	
}
