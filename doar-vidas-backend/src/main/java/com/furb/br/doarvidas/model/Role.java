package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.furb.br.doarvidas.model.entities.BasicEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the Roles that each user has access
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Role extends BasicEntity {

	@Column(nullable=false)
	private String name;

}
