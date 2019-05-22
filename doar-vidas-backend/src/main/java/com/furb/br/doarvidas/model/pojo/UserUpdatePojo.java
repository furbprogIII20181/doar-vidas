package com.furb.br.doarvidas.model.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdatePojo extends BasicPojo {

	private String city;
	private String state;
	private String phone;
	private String description;
	
}
