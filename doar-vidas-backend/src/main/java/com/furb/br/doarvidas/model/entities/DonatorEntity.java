package com.furb.br.doarvidas.model.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.furb.br.doarvidas.model.Donator;
import com.furb.br.doarvidas.model.pojo.DonatorPojo;

@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("D")
@Entity(name = "donator")
public class DonatorEntity extends Donator {

	/**
	 * Default constructor
	 */
	public DonatorEntity() {
		
	}

	public DonatorEntity(DonatorPojo pojo, UserEntity user) {
		this.setName(pojo.getName());
		this.setLastName(pojo.getLastName());
		this.setBloodType(pojo.getBloodType());
		this.setCity(pojo.getCity());
		this.setCpfCnpj(pojo.getCpfCnpj());
		this.setDescription(pojo.getDescription());
		this.setPhone(pojo.getPhone());
		this.setState(pojo.getState());
		this.setUser(user);
	}
	
	@Transient
	public String getDiscriminatorValue(){
	    DiscriminatorValue val = this.getClass().getAnnotation(DiscriminatorValue.class);
	    return val == null ? null : val.value();
	}
	
}
