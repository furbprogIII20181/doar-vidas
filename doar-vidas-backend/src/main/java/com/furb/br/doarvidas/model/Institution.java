package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Representa uma instituição doação (Hemocentro)
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Entity
public class Institution extends Person {

	@Column(nullable = false)
	private Long cnpj;

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	
}
