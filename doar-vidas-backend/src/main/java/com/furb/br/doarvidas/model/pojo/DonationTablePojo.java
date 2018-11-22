package com.furb.br.doarvidas.model.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class DonationTablePojo {

	private String institutionName;
	private String city;
	private String state;
	private Date donationDate;
	
}
