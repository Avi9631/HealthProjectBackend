package com.example.jwt;

import java.time.LocalDate;

public class AppointResponseModel {

	private LocalDate date;
	private String status;
	private String prescrip;
	private String slot;
	private String docname;
	private String docspe;
	public AppointResponseModel(LocalDate date, String status, String prescrip, String slot, String docName,
			String docSpe) {
		super();
		this.date = date;
		this.status = status;
		this.prescrip = prescrip;
		this.slot = slot;
		this.docname = docName;
		this.docspe = docSpe;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrescrip() {
		return prescrip;
	}
	public void setPrescrip(String prescrip) {
		this.prescrip = prescrip;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getDocSpe() {
		return docspe;
	}
	public void setDocSpe(String docspe) {
		this.docspe = docspe;
	}
	
}
