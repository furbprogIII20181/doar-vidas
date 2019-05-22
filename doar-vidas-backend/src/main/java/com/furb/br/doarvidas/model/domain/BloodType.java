package com.furb.br.doarvidas.model.domain;

import javax.persistence.EnumType;

/**
 * Represents the blood types, with its RH Factor.
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public enum BloodType {

	/**
	 * NÃO ALTERAR A ORDEM DOS ENUMS.
	 * Campo é persistido como {@link EnumType#ORDINAL}
	 */
	APOS("A+"),
	ANEG("A-"),
	BPOS("B+"),
	BNEG("B-"),
	ABPOS("AB+"),
	ABNEG("AB-"),
	OPOS("O+"),
	ONEG("O-");
	
	private String description;

	private BloodType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
