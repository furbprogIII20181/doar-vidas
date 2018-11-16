package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.furb.br.doarvidas.model.domain.BloodType;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a Donator
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Donator extends Person {

	@Enumerated
	@Column
	private BloodType bloodType;

}
