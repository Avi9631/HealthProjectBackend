package com.example.jwt;

import java.util.List;

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
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/adddoctor")
	public boolean registerDoctor(@RequestBody DoctorModel u) {
		List<UserModel> list = userService.findUserByEmail(u.getId());
		List<DoctorModel> list1 = userService.findDoctorByEmail(u.getId());
		if (list.isEmpty() && list1.isEmpty()) {
			u.setUserrole("DOCTOR");
			userService.addDoctor(u);
			UserModel u1= new UserModel(u.getId(), u.getName(), u.getDob(), 
					u.getGender(), u.getAddress(), u.getMobile(), u.getPassword(),
					u.getEmail(), "DOCTOR") ;
			userService.addUser(u1);
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping("/delete")
	public void deleteDoctor(@RequestParam("id") String id) {
		userService.deleteDoctor(id);
		userService.deleteDoctorfromUser(id);
	}
	
}
