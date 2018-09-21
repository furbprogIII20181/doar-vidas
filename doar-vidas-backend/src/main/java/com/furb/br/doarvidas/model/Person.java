package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 * Representa uma Pessoa
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity
public class Person extends BasicEntity {
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(insertable=false, updatable=false)
	private String tipo;
	
	/**
	 * Contém o DDD+Telefone
	 */
	@Column(nullable = false)
	private String phone;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private UserEntity user;
	
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
