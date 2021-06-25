package com.example.jwt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, String>{

	List<DoctorModel> findBySpecialization(String speciality);

	List<DoctorModel> findByEmail(String id);

}
