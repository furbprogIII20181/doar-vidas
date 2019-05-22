package com.furb.br.doarvidas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.furb.br.doarvidas.model.entities.BasicEntity;
import com.furb.br.doarvidas.model.entities.RoleEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an User
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Getter
@Setter
@MappedSuperclass
public abstract class User extends BasicEntity {

	@Column(nullable=false, unique=true)
    private String email;
	
	@Column(nullable=false)
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RoleEntity> roles;

}
