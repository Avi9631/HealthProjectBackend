package com.example.jwt;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/u")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllDoctor")
	public List<DoctorModel> getAllDoctors(){
		return userService.loadAllDoctors();
	}
	
	@GetMapping("/searchDoctor")
	public List<DoctorModel> finddoctor(@RequestParam("speciality") String speciality){
		return userService.searchDoctor(speciality);
	}
	
	@GetMapping("/docID")
	public Optional<DoctorModel> searchDdoctor(@RequestParam("id") String id){
		return userService.searchDoctorById(id);
	}
	
	@GetMapping("/loadprofile")
	public Optional<UserModel> loadProfile(@RequestParam("id") String id){
		return userService.loadUserProfile(id);
	}
	
	@GetMapping("/getAppoint")
	public List<AppointResponseModel> getMyAppoint(@RequestParam("id") String id){
//		List<AppointModel> list= userService.getAppointmentList(id);
//		return list;
		return userService.getAppointmentList(id);
		
	}

	@PostMapping("/logup")
	private boolean logUp(@RequestBody UserModel u) {
		List<UserModel> list = userService.findUserByEmail(u.getId());
		if (list.isEmpty()) {
			u.setUserrole("USER");
			userService.addUser(u);
			return true;
		} else {
			return false;
		}
	}
	
	@PostMapping("/bookAppoint")
	public boolean bookAppoint(@RequestBody AppointModel a) {
		String uuid= String.valueOf(UUID.randomUUID());
		a.setId(uuid);
		return userService.bookAppointment(a);
	}
	
	@PostMapping("/checkSlot")
	public boolean checkAvailability(@RequestParam("docid") String did,
			@RequestParam("date") LocalDate date,
			@RequestParam("slot") String slot) {
		
		List<AppointModel> list = userService.checkAppointedAvailability(did, slot, date );
		if(list.size()==0) {
			return true; 
		}else {
			return false;
		}
	}
	
}
