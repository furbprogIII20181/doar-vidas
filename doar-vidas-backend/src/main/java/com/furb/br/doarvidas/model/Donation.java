package com.furb.br.doarvidas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * Representa uma doação
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Entity
public class Donation extends BasicEntity {

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private Donator donator;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private Institution institution;
	
	@Column(nullable = false)
	private Date date;

	public Donator getDonator() {
		return donator;
	}

	public void setDonator(Donator donator) {
		this.donator = donator;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
