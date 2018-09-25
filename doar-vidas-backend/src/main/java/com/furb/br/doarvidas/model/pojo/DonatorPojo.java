package com.furb.br.doarvidas.model.pojo;

import com.furb.br.doarvidas.model.domain.BloodType;
import com.furb.br.doarvidas.model.entities.DonatorEntity;

/**
 * Pojo for {@link DonatorEntity}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public class DonatorPojo extends PersonPojo {

	private Long cpf;
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
