package com.example.jwt;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointRepo extends JpaRepository<AppointModel, String> {

	Object findByDocid(String docid);

	List<AppointModel> findAllByUserid(String id);

	List<AppointModel> findAllByDocid(String id);

	List<AppointModel> findAllByDocidAndStatus(String id, String status);

	List<AppointModel> findByDocidAndDateAndSlot(String docid, LocalDate localDate, String slot);
	
	@Query(value="select new com.example.jwt.AppointResponseModel(a.date, a.status, a.prescrip, a.slot, b.name, b.specialization)"
			+ " from AppointModel a JOIN DoctorModel b ON a.docid = b.id WHERE a.userid=:id")
	List<AppointResponseModel> findAppoint(String id);

}
