package com.basic.Hospital.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.Hospital.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
