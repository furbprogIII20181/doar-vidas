package com.furb.br.doarvidas.model.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.furb.br.doarvidas.model.Institution;
import com.furb.br.doarvidas.model.pojo.DonatorPojo;
import com.furb.br.doarvidas.model.pojo.InstitutionPojo;

@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("I")
@Entity
public class InstitutionEntity extends Institution {

	public InstitutionEntity() {
		// Default constructor
	}

	public InstitutionEntity(InstitutionPojo pojo, UserEntity user) {
		this.setCnpj(pojo.getCnpj());
		this.setName(pojo.getName());
		this.setCity(pojo.getCity());
		this.setDescription(pojo.getDescription());
		this.setPhone(pojo.getPhone());
		this.setState(pojo.getState());
		this.setTipo(pojo.getTipo());
		this.setUser(user);
	}
	
}
