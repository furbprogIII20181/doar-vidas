package com.furb.br.doarvidas.model.entities;

import javax.persistence.Entity;

import com.furb.br.doarvidas.model.Solicitation;
import com.furb.br.doarvidas.model.pojo.SolicitationPojo;

@Entity(name = "solicitation")
public class SolicitationEntity extends Solicitation {

	/**
	 * Default constructor
	 */
	public SolicitationEntity() {

	}

	public SolicitationEntity(SolicitationPojo pojo, InstitutionEntity institution) {
		this.setId(pojo.getId());
		this.setBloodType(pojo.getBloodType());
		this.setQuantity(pojo.getQuantity());
		this.setInstitution(institution);
	}
	
}
