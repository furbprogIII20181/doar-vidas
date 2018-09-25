package com.furb.br.doarvidas.model.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.furb.br.doarvidas.model.Donator;
import com.furb.br.doarvidas.model.pojo.DonatorPojo;

@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("D")
@Entity(name = "donator")
public class DonatorEntity extends Donator {

	public DonatorEntity() {
		// Default constructor
	}

	public DonatorEntity(DonatorPojo pojo, UserEntity user) {
		this.setName(pojo.getName());
		this.setBloodType(pojo.getBloodType());
		this.setCity(pojo.getCity());
		this.setCpf(pojo.getCpf());
		this.setDescription(pojo.getDescription());
		this.setPhone(pojo.getPhone());
		this.setState(pojo.getState());
		this.setTipo(pojo.getTipo());
		this.setUser(user);
	}
	
}
