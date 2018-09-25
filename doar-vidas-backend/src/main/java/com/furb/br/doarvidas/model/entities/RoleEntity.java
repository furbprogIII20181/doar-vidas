package com.furb.br.doarvidas.model.entities;

import javax.persistence.Entity;

import com.furb.br.doarvidas.model.Role;

/**
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Entity(name="Role")
public class RoleEntity extends Role {

	public RoleEntity() {
		//Default constructor
	}
	
	public RoleEntity(String name) {
		setName(name);
	}
	
}
