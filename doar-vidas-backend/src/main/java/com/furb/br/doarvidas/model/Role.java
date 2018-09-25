package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.furb.br.doarvidas.model.entities.BasicEntity;

/**
 * Represents the Roles that each user has access
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@MappedSuperclass
public abstract class Role extends BasicEntity {

	@Column(nullable=false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
