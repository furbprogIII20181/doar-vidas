package com.furb.br.doarvidas.model.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a Donation Pojo
 * 
 * @author Marcelo Wippel
 */
@Getter
@Setter
public class DonationPojo extends BasicPojo {

	private Integer donatorID;
	private Integer institutionID;
	private Date date;
	
}
