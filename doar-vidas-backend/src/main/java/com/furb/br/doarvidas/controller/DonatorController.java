package com.furb.br.doarvidas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.furb.br.doarvidas.model.DonatorEntity;
import com.furb.br.doarvidas.repository.DonatorRepository;

/**
 * Default endpoint
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@RestController
@RequestMapping("/rest/public/donator")
public class DonatorController {

	@Autowired
	private DonatorRepository donatorRepo;
	
	@RequestMapping(method = RequestMethod.POST, value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody DonatorEntity entity){
		DonatorEntity savedUser = donatorRepo.save(entity);
    	return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

}