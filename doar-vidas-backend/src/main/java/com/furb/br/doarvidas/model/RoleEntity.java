package com.furb.br.doarvidas.model;

import javax.persistence.Entity;

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
