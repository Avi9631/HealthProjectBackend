package com.example.jwt;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private UserService user;
	
	@GetMapping("/getAppoint")
	public List<AppointModel> getDocAppoint(@RequestParam("id") String id) {
		return user.getDoctorAppoint(id);
	}
	
	@GetMapping("/accept")
	public void acceptAppoint(@RequestParam("id") String id) {
		Optional<AppointModel> list =user.getAppointByID(id);
		AppointModel a= list.get();
		user.acceptAppointment(a);
	}

	@GetMapping("/reject")
	public void rejectAppoint(@RequestParam("id") String id) {
		Optional<AppointModel> list =user.getAppointByID(id);
		AppointModel a= list.get();
		user.rejectAppointment(a);
	}
	
	@GetMapping("/uploadPrescrip")
	public void uploadPres(@RequestParam("id") String id, @RequestParam("prescrip") String pres) {
		Optional<AppointModel> list =user.getAppointByID(id);
		AppointModel a= list.get();
		a.setPrescrip(pres);
		user.uploadPrescription(a);
	}
	
	@GetMapping("/getuser")
	public Optional<UserModel> getuser(@RequestParam("id") String id) {
		return user.loadUserProfile(id);
	}
	
	
	
}
