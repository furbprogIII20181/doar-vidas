package com.furb.br.doarvidas.model.pojo;

import com.furb.br.doarvidas.model.domain.BloodType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitationPojo extends BasicPojo {

	private Integer institutionID;
	private BloodType bloodType;
	private Double quantity;
	
}
