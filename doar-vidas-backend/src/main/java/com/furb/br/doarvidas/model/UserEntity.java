package com.furb.br.doarvidas.model;

import java.util.List;

import javax.persistence.Entity;

/**
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Entity(name = "User")
public class UserEntity extends User {

	public UserEntity() {
		//Default constructor
	}
	
	public UserEntity(String email, String password, List<RoleEntity> roles) {
		setEmail(email);
		setPassword(password);
		setRoles(roles);
	}
	
}
