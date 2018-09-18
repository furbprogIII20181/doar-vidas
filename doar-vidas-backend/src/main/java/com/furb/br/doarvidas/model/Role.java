package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Representa as permissões
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Entity
public class Role extends BasicEntity {

	@Column(nullable=false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
