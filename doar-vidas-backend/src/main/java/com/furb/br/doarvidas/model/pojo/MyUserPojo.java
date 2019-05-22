package com.furb.br.doarvidas.model.pojo;

import com.furb.br.doarvidas.model.domain.BloodType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyUserPojo extends BasicPojo {

	private String name;
	private String lastName;
	private String city;
	private String state;
	private String phone;
	private String description;
	private String email;
	private Long cpfCnpj;
	private BloodType bloodType;
	
}
