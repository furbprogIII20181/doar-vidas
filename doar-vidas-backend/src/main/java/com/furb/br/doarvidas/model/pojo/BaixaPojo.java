package com.furb.br.doarvidas.model.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Representa uma baixa de quantidade de doação no sistema
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Getter
@Setter
public class BaixaPojo extends BasicPojo {

	private Double quantity;
	
}
