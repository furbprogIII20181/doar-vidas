package com.furb.br.doarvidas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@RestController
public class HomeController {

	@GetMapping(value="")
	public String home() {
		return "home";
	}
	
	@GetMapping(value="/private")
	public String privateArea() {
		return "private";
	}
	
}
