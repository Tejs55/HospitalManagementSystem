package com.basic.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.Hospital.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
