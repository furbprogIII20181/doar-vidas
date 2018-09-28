package com.furb.br.doarvidas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.furb.br.doarvidas.model.entities.DonatorEntity;
import com.furb.br.doarvidas.model.entities.UserEntity;
import com.furb.br.doarvidas.model.pojo.DonatorPojo;
import com.furb.br.doarvidas.repository.DonatorRepository;
import com.furb.br.doarvidas.services.UserService;

/**
 * EndPoint for {@link DonatorEntity}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/rest/public/donator")
public class DonatorController {

	@Autowired
	private DonatorRepository donatorRepo;
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody DonatorPojo donator){
		UserEntity savedUser = service.save(new UserEntity(donator.getEmail(), donator.getPassword(), donator.getRoles()));
		DonatorEntity savedDonator = donatorRepo.save(new DonatorEntity(donator, savedUser));
    	return new ResponseEntity<>(savedDonator, HttpStatus.OK);
    }

}