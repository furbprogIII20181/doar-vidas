package com.furb.br.doarvidas.model.pojo;

import com.furb.br.doarvidas.model.domain.BloodType;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a customized Solicitation
 * 
 * @author mawippel2@hotmail.com
 */
@Getter
@Setter
public class SolicitationDonationPojo extends BasicPojo {

	private Integer id;
	private Integer institutionId;
	private String name;
	private String lastName;
	private String city;
	private String state;
	private String description;
	private BloodType bloodType;
	
}
