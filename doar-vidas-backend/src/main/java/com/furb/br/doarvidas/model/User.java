package com.furb.br.doarvidas.model;

import javax.persistence.Entity;

/**
 * Entidade que representa um Usuário
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Entity
public class User extends BasicEntity {

	private String name;

    private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
