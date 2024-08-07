package com.basic.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.Hospital.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
