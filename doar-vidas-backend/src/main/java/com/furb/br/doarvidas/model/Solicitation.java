package com.furb.br.doarvidas.model;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.furb.br.doarvidas.model.domain.BloodType;
import com.furb.br.doarvidas.model.entities.BasicEntity;
import com.furb.br.doarvidas.model.entities.InstitutionEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a solicitation of a {@link Donation}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Solicitation extends BasicEntity {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private InstitutionEntity institution;
	
	@Enumerated
	@Column(nullable = false)
	private BloodType bloodType;
	
	@Column(nullable = false)
	private Double quantity;

}
