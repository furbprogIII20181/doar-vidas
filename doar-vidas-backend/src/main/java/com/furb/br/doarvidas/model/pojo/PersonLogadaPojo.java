package com.furb.br.doarvidas.model.pojo;

/**
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
