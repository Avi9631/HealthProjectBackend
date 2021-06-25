package com.example.jwt;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="appoint_table")
public class AppointModel {

	@Id
	private String id;
	private String userid;
	private String docid;
	private String prescrip;
	private LocalDate date;
	private String slot;
	private String status;
	
	public AppointModel(){
		
	}

	public AppointModel(String id, String userid, String docid, String prescrip, LocalDate date, String slot,
			String status) {
		super();
		this.id = id;
		this.userid = userid;
		this.docid = docid;
		this.prescrip = prescrip;
		this.date = date;
		this.slot = slot;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getPrescrip() {
		return prescrip;
	}

	public void setPrescrip(String prescrip) {
		this.prescrip = prescrip;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
