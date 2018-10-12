package com.furb.br.doarvidas.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class DonatorController extends AbstractController<DonatorPojo> {

	@Autowired
	private DonatorRepository donatorRepo;
	
	@Autowired
	private UserService service;

	@Override
    public ResponseEntity<?> save(@RequestBody DonatorPojo donator) {
		// Salva o usuário para poder salvar o Donator
		UserEntity savedUser = service.save(new UserEntity(donator.getEmail(), donator.getPassword(), donator.getRoles()));
		// Salva o donator
		DonatorEntity savedDonator = donatorRepo.save(new DonatorEntity(donator, savedUser));
    	return new ResponseEntity<>(savedDonator, HttpStatus.OK);
    }

	@Override
    public ResponseEntity<?> listAll(){
		Iterable<DonatorEntity> allDonators = donatorRepo.findAll();
		List<DonatorEntity> donators = StreamSupport
			    .stream(allDonators.spliterator(), false)
			    .collect(Collectors.toList());
    	return new ResponseEntity<>(donators, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> deleteById(Integer id) {
		donatorRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}