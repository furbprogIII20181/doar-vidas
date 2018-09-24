package com.furb.br.doarvidas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Representa uma doação
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@MappedSuperclass
public abstract class Donation extends BasicEntity {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private DonatorEntity donator;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private InstitutionEntity institution;
	
	@Column(nullable = false)
	private Date date;

	public DonatorEntity getDonator() {
		return donator;
	}

	public void setDonator(DonatorEntity donator) {
		this.donator = donator;
	}

	public InstitutionEntity getInstitution() {
		return institution;
	}

	public void setInstitution(InstitutionEntity institution) {
		this.institution = institution;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
