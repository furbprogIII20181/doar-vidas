package com.furb.br.doarvidas.controller;

import java.util.Optional;

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
import com.furb.br.doarvidas.model.entities.InstitutionEntity;
import com.furb.br.doarvidas.model.entities.UserEntity;
import com.furb.br.doarvidas.model.pojo.EmailPojo;
import com.furb.br.doarvidas.model.pojo.PersonLogadaPojo;
import com.furb.br.doarvidas.repository.DonatorRepository;
import com.furb.br.doarvidas.repository.InstitutionRepository;
import com.furb.br.doarvidas.repository.UserRepository;

/**
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/rest/private/user")
public class UserController {

	@Autowired
    private UserRepository repo;
	
	@Autowired
    private InstitutionRepository institutionRepo;
	
	@Autowired
    private DonatorRepository donatorRepo;
	
	@RequestMapping(method = RequestMethod.POST, value = "findByEmail", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByEmail(@RequestBody EmailPojo emailPojo) {
		// Salva o donator
		Optional<UserEntity> user = repo.findByEmail(emailPojo.getEmail());
		
		if (user.isPresent()) {
			Optional<InstitutionEntity> institution = institutionRepo.findByUser(user.get());
			
			if (institution.isPresent()) {
				InstitutionEntity institutionEntity = institution.get();
				PersonLogadaPojo plPojo = new PersonLogadaPojo(institutionEntity.getId(), user.get().getEmail(),
						institutionEntity.getName(), institutionEntity.getDiscriminatorValue());
				return new ResponseEntity<>(plPojo, HttpStatus.OK);
			} else {
				Optional<DonatorEntity> donator = donatorRepo.findByUser(user.get());
				if (donator.isPresent()) {
					DonatorEntity donatorEntity = donator.get();
					PersonLogadaPojo plPojo = new PersonLogadaPojo(donatorEntity.getId(), user.get().getEmail(),
					donatorEntity.getName(), donatorEntity.getDiscriminatorValue());
					return new ResponseEntity<>(plPojo, HttpStatus.OK);
				}
			}
		}
    	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
	
}
