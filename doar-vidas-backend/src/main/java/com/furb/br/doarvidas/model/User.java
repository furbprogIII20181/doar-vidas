package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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
	
	@Column(nullable=false)
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Role role;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
