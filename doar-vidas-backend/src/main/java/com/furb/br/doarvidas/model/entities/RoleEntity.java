package com.furb.br.doarvidas.model.entities;

import javax.persistence.Entity;

import com.furb.br.doarvidas.model.Role;

@Entity(name="Role")
public class RoleEntity extends Role {

	/**
	 * Default constructor
	 */
	public RoleEntity() {
	}
	
	public RoleEntity(String name) {
		setName(name);
	}
	
}
