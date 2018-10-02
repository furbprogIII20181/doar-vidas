package com.furb.br.doarvidas.model.pojo;

import com.furb.br.doarvidas.model.entities.InstitutionEntity;

/**
 * Pojo for {@link InstitutionEntity}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public class InstitutionPojo extends PersonPojo {

	private Long cnpj;

	public InstitutionPojo() {
	}

	public InstitutionPojo(InstitutionEntity entity) {
		this.setName(entity.getName());
		this.setLastName(entity.getLastName());
		this.setCity(entity.getCity());
		this.setDescription(entity.getDescription());
		this.setPhone(entity.getPhone());
		this.setState(entity.getState());
		this.setCnpj(entity.getCnpj());
	}
	
	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	
}
