package com.furb.br.doarvidas.model.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Entidade base para todas as outras. Contém o ID.
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@MappedSuperclass
public abstract class BasicEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	/**
	 * Retorna o ID
	 * @return um {@link Integer}
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Seta o ID
	 * @param id - Um {@link Integer}
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
}
