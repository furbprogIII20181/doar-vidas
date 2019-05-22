package com.furb.br.doarvidas.model.entities;

import java.util.List;

import javax.persistence.Entity;

import com.furb.br.doarvidas.model.User;

/**
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Entity(name = "User")
public class UserEntity extends User {

	/**
	 * Default constructor
	 */
	public UserEntity() {

	}
	
	public UserEntity(String email, String password, List<RoleEntity> roles) {
		setEmail(email);
		setPassword(password);
		setRoles(roles);
	}
	
}
