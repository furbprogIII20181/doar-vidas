package com.furb.br.doarvidas.model.pojo;

import java.util.Date;

public class DonationPojo extends BasicPojo {

	private Integer donatorID;
	private Integer institutionID;
	private Date date;
	
	public Integer getDonatorID() {
		return donatorID;
	}
	
	public void setDonatorID(Integer donatorID) {
		this.donatorID = donatorID;
	}
	
	public Integer getInstitutionID() {
		return institutionID;
	}
	
	public void setInstitutionID(Integer institutionID) {
		this.institutionID = institutionID;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
}
