package com.furb.br.doarvidas.model.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DonationTablePojo extends BasicPojo {

	private String institutionName;
	private String city;
	private String state;
	private Date donationDate;
	
	public DonationTablePojo(Integer id, String institutionName, String city, String state, Date donationDate) {
		super();
		super.setId(id);
		this.institutionName = institutionName;
		this.city = city;
		this.state = state;
		this.donationDate = donationDate;
	}
	
}
