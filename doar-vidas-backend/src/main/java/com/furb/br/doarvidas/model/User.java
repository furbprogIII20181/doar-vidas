package com.furb.br.doarvidas.model;

import java.util.Set;

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
	private String userName;

	@Column(nullable=false)
    private String email;
	
	@Column(nullable=false)
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Role> roles;

	public User(User user) {
		this.setId(user.getId());
		this.setUserName(user.getUserName());
		this.setEmail(user.getEmail());
		this.setPassword(user.getPassword());
		this.setRoles(user.getRoles());
	}

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
