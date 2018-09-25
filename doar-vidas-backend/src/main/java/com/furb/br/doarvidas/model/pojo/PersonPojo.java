package com.furb.br.doarvidas.model.pojo;

import java.util.List;

import com.furb.br.doarvidas.model.Person;
import com.furb.br.doarvidas.model.entities.RoleEntity;

/**
 * Pojo for {@link Person}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public abstract class PersonPojo extends BasicPojo {

	private String name;
	private String city;
	private String state;
	private String tipo;
	private String phone;
	private String description;
	
	//User's informations
	private String email;
	private String password;
	private List<RoleEntity> roles;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

}
