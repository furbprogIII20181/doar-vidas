package com.furb.br.doarvidas.model.pojo;

import com.furb.br.doarvidas.model.entities.InstitutionEntity;

/**
 * Pojo for {@link InstitutionEntity}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public class InstitutionPojo extends PersonPojo {

	private Long cnpj;

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	
}
