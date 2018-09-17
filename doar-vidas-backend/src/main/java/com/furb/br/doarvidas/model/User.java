package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Representa um Usuário
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Entity
public class User extends BasicEntity {

	@Column(nullable=false)
	private String userName;

	@Column(nullable=false)
    private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
