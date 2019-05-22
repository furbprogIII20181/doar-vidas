package com.furb.br.doarvidas.model.pojo;

import com.furb.br.doarvidas.model.domain.BloodType;
import com.furb.br.doarvidas.model.entities.DonatorEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo for {@link DonatorEntity}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Getter
@Setter
public class DonatorPojo extends PersonPojo {

	private BloodType bloodType;

	public DonatorPojo() {
	}

	public DonatorPojo(DonatorEntity entity) {
		this.setName(entity.getName());
		this.setLastName(entity.getLastName());
		this.setBloodType(entity.getBloodType());
		this.setCity(entity.getCity());
		this.setCpfCnpj(entity.getCpfCnpj());
		this.setDescription(entity.getDescription());
		this.setPhone(entity.getPhone());
		this.setState(entity.getState());
	}
	
}
