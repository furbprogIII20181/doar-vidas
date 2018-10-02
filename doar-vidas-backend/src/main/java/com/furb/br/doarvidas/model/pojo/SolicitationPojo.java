package com.furb.br.doarvidas.model.pojo;

import com.furb.br.doarvidas.model.domain.BloodType;

public class SolicitationPojo extends BasicPojo {

	private Integer institutionID;
	private BloodType bloodType;
	private Double quantity;
	
	public Integer getInstitutionID() {
		return institutionID;
	}
	
	public void setInstitutionID(Integer institutionID) {
		this.institutionID = institutionID;
	}
	
	public BloodType getBloodType() {
		return bloodType;
	}
	
	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}
	
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
}
