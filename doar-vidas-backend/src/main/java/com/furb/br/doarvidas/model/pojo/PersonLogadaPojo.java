package com.furb.br.doarvidas.model.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Getter
@Setter
public class PersonLogadaPojo extends BasicPojo {

	private String email;
	private String name;
	private String type;

	public PersonLogadaPojo(Integer id, String email, String name, String type) {
		this.setId(id);
		this.email = email;
		this.name = name;
		this.type = type;
	}
	
}
