package com.furb.br.doarvidas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.furb.br.doarvidas.model.entities.BasicEntity;
import com.furb.br.doarvidas.model.entities.DonatorEntity;
import com.furb.br.doarvidas.model.entities.InstitutionEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a Donation
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Donation extends BasicEntity {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private DonatorEntity donator;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private InstitutionEntity institution;
	
	@Column(nullable = false)
	private Date date;

}
