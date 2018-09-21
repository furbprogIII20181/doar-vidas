package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Representa uma instituição doação (Hemocentro)
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("I")
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
