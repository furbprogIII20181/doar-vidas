package com.furb.br.doarvidas.model.entities;

import java.util.Date;

import javax.persistence.Entity;

import com.furb.br.doarvidas.model.Donation;

@Entity(name = "donation")
public class DonationEntity extends Donation {

	public DonationEntity() {
		
	}

	public DonationEntity(Date date, DonatorEntity donatorEntity, InstitutionEntity institutionEntity) {
		this.setDate(date);
		this.setDonator(donatorEntity);
		this.setInstitution(institutionEntity);
	}
	
}
