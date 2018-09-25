package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.furb.br.doarvidas.model.domain.BloodType;
import com.furb.br.doarvidas.model.entities.BasicEntity;
import com.furb.br.doarvidas.model.entities.InstitutionEntity;

/**
 * Represents a solicitation of a {@link Donation}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@MappedSuperclass
public abstract class Solicitation extends BasicEntity {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private InstitutionEntity institution;
	
	@Enumerated
	@Column(nullable = false)
	private BloodType bloodType;
	
	@Column(nullable = false)
	private Double quantity;

	public InstitutionEntity getInstitution() {
		return institution;
	}

	public void setInstitution(InstitutionEntity institution) {
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
