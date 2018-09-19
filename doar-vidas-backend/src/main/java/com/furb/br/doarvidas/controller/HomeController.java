package com.furb.br.doarvidas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@RequestMapping("/rest")
@RestController
public class HomeController {

	@GetMapping(value = "/login")
    public String login(){
        return "tela de login";
    }
    
	@GetMapping(value = "/register")
    public String register(){
    	return "tela de registro";
    }

	@GetMapping(value = "/private")
    public String privateArea(){
        return "Área privada";
    }

}