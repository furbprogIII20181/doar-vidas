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

	public DonatorPojo() {
	}

	public DonatorPojo(DonatorEntity entity) {
		this.setName(entity.getName());
		this.setLastName(entity.getLastName());
		this.setBloodType(entity.getBloodType());
		this.setCity(entity.getCity());
		this.setCpf(entity.getCpf());
		this.setDescription(entity.getDescription());
		this.setPhone(entity.getPhone());
		this.setState(entity.getState());
	}
	
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
