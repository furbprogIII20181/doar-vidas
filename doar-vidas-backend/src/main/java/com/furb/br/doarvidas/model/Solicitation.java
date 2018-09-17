package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * Representa uma solicitação de doação
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Entity
public class Solicitation extends BasicEntity {

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private Institution institution;
	
	@Column(nullable = false)
	private BloodType bloodType;
	
	@Column(nullable = false)
	private Double quantity;

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
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
