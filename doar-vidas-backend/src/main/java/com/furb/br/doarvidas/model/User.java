package com.furb.br.doarvidas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Representa um Usuário
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Entity
public class User extends BasicEntity {

	@Column(nullable=false)
    private String email;
	
	@Column(nullable=false)
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Role> roles;

	public User(String email, String password, List<Role> roles) {
		this.email = email;
		this.password = password;
		this.roles = roles;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
