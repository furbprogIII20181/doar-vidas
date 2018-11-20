package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.furb.br.doarvidas.model.entities.BasicEntity;
import com.furb.br.doarvidas.model.entities.UserEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a Person
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Getter
@Setter
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity
public class Person extends BasicEntity {
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String lastName;
	
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
	private UserEntity user;
	
	@Column(length = 1000)
	private String description;

	@Column(nullable = false)
	private Long cpfCnpj;
	
}
