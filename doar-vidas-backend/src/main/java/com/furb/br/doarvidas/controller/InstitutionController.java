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

import com.furb.br.doarvidas.model.entities.InstitutionEntity;
import com.furb.br.doarvidas.model.entities.UserEntity;
import com.furb.br.doarvidas.model.pojo.InstitutionPojo;
import com.furb.br.doarvidas.repository.InstitutionRepository;
import com.furb.br.doarvidas.services.UserService;

/**
 * EndPoint for {@link InstitutionEntity}
 * 
 * @author marcelo.wippel
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/rest/public/institution")
public class InstitutionController extends AbstractController<InstitutionPojo> {

	@Autowired
	private InstitutionRepository institutionRepo;

	@Autowired
	private UserService service;

	@Override
    public ResponseEntity<?> save(@RequestBody InstitutionPojo institution) {
		UserEntity savedUser = service.save(new UserEntity(institution.getEmail(), institution.getPassword(), institution.getRoles()));
		InstitutionEntity savedInstitution = institutionRepo.save(new InstitutionEntity(institution, savedUser));
    	return new ResponseEntity<>(savedInstitution, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> deleteById(Integer id) {
		institutionRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> listAll() {
		Iterable<InstitutionEntity> allInstitutions = institutionRepo.findAll();
		List<InstitutionEntity> institutions = StreamSupport
			    .stream(allInstitutions.spliterator(), false)
			    .collect(Collectors.toList());
    	return new ResponseEntity<>(institutions, HttpStatus.OK);
	}
	
}
