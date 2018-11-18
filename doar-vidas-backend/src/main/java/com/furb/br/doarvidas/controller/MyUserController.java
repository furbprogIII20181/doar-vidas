package com.furb.br.doarvidas.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furb.br.doarvidas.model.Person;
import com.furb.br.doarvidas.model.entities.DonatorEntity;
import com.furb.br.doarvidas.model.pojo.MyUserPojo;
import com.furb.br.doarvidas.model.pojo.UserUpdatePojo;
import com.furb.br.doarvidas.repository.PersonRepository;

/**
 * Endpoint for retrieve the user data
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/rest/private/user")
public class MyUserController {

	@Autowired
	private PersonRepository personRepo;

	@GetMapping(value = "/{id:[0-9][0-9]*}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		
		Optional<Person> personOpt = personRepo.findById(id);
		
		if (personOpt.isPresent()) {
			Person person = personOpt.get();
			
			MyUserPojo pojo = new MyUserPojo();
			pojo.setId(id);
			pojo.setName(person.getName());
			pojo.setLastName(person.getLastName());
			pojo.setPhone(person.getPhone());
			pojo.setState(person.getState());
			pojo.setCity(person.getCity());
			pojo.setDescription(person.getDescription());
			pojo.setCpfCnpj(person.getCpfCnpj());
			pojo.setEmail(person.getUser().getEmail());
			
			if (person instanceof DonatorEntity) {
				pojo.setBloodType(((DonatorEntity) person).getBloodType());
			}
			
			return new ResponseEntity<>(pojo, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	// TODO testar se este metodo funciona
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> partialUpdateName(@PathVariable("id") UserUpdatePojo pojo, @RequestBody Integer id) {
		Optional<Person> personPojo = personRepo.findById(id);
		if (personPojo.isPresent()) {
			Person person = personPojo.get();
			BeanUtils.copyProperties(pojo, person);
			personRepo.save(person);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}
