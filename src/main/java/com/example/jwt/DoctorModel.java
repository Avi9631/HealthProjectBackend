package com.example.jwt;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="doctor_table")
public class DoctorModel {
	
	@Id
	private String id;
	private String name;
	private String address;
	private String dob;
	private String password;
	private String experience;
	private String email;
	private String mobile;
	private String gender;
	private String specialization;
	private String userrole;
	
	public DoctorModel() {
		// TODO Auto-generated constructor stub
	}

	public DoctorModel(String id, String name, String address, String dob, String password, String experience,
			String email, String mobile, String gender, String specialization, String userrole) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.password = password;
		this.experience = experience;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.specialization = specialization;
		this.userrole = userrole;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	
	
}
