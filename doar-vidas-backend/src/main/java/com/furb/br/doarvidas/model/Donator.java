package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.furb.br.doarvidas.model.domain.BloodType;

/**
 * Represents a Donator
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@MappedSuperclass
public abstract class Donator extends Person {

	@Column
	private Long cpf;
	
	@Enumerated
	@Column
	private BloodType bloodType;

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}
	
}
