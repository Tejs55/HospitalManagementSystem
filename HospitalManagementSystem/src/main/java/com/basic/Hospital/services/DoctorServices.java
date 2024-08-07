package com.basic.Hospital.services;

import java.util.List;

import com.basic.Hospital.dto.DoctorDto;

public interface DoctorServices {

	DoctorDto saveDoctorinformation(DoctorDto entity);

	List<DoctorDto> readAllDoctors();

	DoctorDto readDetailById(Long id);

	DoctorDto updateDoctorDetails(Long id, DoctorDto doctorDto);

	DoctorDto deleteDetail(Long id);

}
