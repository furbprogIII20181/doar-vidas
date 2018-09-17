package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * Representa uma Pessoa
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@MappedSuperclass
public abstract class Person extends BasicEntity {
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	/**
	 * Contém o DDD+Telefone
	 */
	@Column(nullable = false)
	private String phone;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private User user;
	
	private String description;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
