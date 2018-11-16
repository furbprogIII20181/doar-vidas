package com.furb.br.doarvidas.model.pojo;

import java.util.List;

import com.furb.br.doarvidas.model.Person;
import com.furb.br.doarvidas.model.entities.RoleEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo for {@link Person}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Getter
@Setter
public abstract class PersonPojo extends BasicPojo {

	private String name;
	private String lastName = "";
	private String city;
	private String state;
	private String phone;
	private String description;
	private Long cpfCnpj;
	private String tipo;
	
	//User's informations
	private String email;
	private String password;
	private List<RoleEntity> roles;

}
