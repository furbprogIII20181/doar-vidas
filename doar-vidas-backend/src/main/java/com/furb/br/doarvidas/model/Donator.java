package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * Representa um Doador
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Entity
public class Donator extends Person {

	@Column(nullable = false)
	private Long cpf;
	
	@Enumerated
	@Column(nullable = false)
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
