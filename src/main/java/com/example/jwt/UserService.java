package com.example.jwt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private DoctorRepository repoDoc;
	
	@Autowired
	private UserRepository repoUser;
	
	@Autowired
	private AppointRepo repoAppoint;

	
	public List<DoctorModel> loadAllDoctors() {
		return repoDoc.findAll();
	}

	public List<DoctorModel> searchDoctor(String speciality) {
		return repoDoc.findBySpecialization(speciality);
	}
	
	public Optional<DoctorModel> searchDoctorById(String id) {
		return repoDoc.findById(id);
	}
	
	public Optional<UserModel> loadUserProfile(String id) {
		return repoUser.findById(id);
	}

	public List<AppointResponseModel> getAppointmentList(String id) {
//		return repoAppoint.findAllByUserid(id);
		return repoAppoint.findAppoint(id);
		
	}

	public boolean bookAppointment(AppointModel a) {
		List<AppointModel> list = checkAppointedAvailability(a.getDocid(), a.getSlot(), a.getDate());
		if(list.size()==0) {
			repoAppoint.save(a);
			return true; 
		}else {
			return false;
		}
	}
	
	public List<AppointModel> checkAppointedAvailability(String docid, String slot, LocalDate localDate) {
		return repoAppoint.findByDocidAndDateAndSlot(docid, localDate, slot);
	}

	// Doctor Area

	public List<AppointModel> showPendingAppointments(String id, String status) {
		return repoAppoint.findAllByDocidAndStatus(id, status);
	}

	public void acceptAppointment(AppointModel a) {
		a.setStatus("Accepted");
		repoAppoint.save(a);
	}

	public void rejectAppointment(AppointModel a) {
	    a.setStatus("Rejected");
		repoAppoint.save(a);
	}

	public void uploadPrescription(AppointModel a) {
		repoAppoint.save(a);
	}
	
	public List<UserModel> findUserByEmail(String id){
		return repoUser.findByEmail(id);
	}
	
	public List<DoctorModel> findDoctorByEmail(String id){
		return repoDoc.findByEmail(id);
	}

	public void addUser(UserModel u) {
		// TODO Auto-generated method stub
		repoUser.save(u);
	}

	public void addDoctor(DoctorModel u) {
		repoDoc.save(u);		
	}
	
	public void deleteDoctor(String id) {
		repoDoc.deleteById(id);
	}
	
	public List<AppointModel> getDoctorAppoint(String id) {
		return repoAppoint.findAllByDocid(id);
	}

	public void deleteDoctorfromUser(String id) {
		repoUser.deleteById(id);
	}
	
	
	public Optional<AppointModel> getAppointByID(String id) {
		return repoAppoint.findById(id);
	}
	

}
