package com.furb.br.doarvidas.controller;

import java.util.List;
import java.util.Optional;
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
import com.furb.br.doarvidas.model.entities.SolicitationEntity;
import com.furb.br.doarvidas.model.pojo.SolicitationPojo;
import com.furb.br.doarvidas.repository.InstitutionRepository;
import com.furb.br.doarvidas.repository.SolicitationRepository;

/**
 * EndPoint for {@link SolicitationEntity}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/rest/private/solicitation")
public class SolicitationController extends AbstractController<SolicitationPojo> {

	@Autowired
	private SolicitationRepository solicitationRepo;
	
	@Autowired
	private InstitutionRepository institutionRepo;

	@Override
    public ResponseEntity<?> save(@RequestBody SolicitationPojo solicitation) {
		Optional<InstitutionEntity> institution = institutionRepo.findById(solicitation.getInstitutionID());
		if (institution.isPresent()) {
			SolicitationEntity savedSolicitation = solicitationRepo.save(new SolicitationEntity(solicitation, institution.get()));
			return new ResponseEntity<>(savedSolicitation, HttpStatus.OK);
		}
    	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

	@Override
    public ResponseEntity<?> listAll(){
		Iterable<SolicitationEntity> allSolicitation = solicitationRepo.findAll();
		List<SolicitationEntity> solicitations = StreamSupport
			    .stream(allSolicitation.spliterator(), false)
			    .collect(Collectors.toList());
    	return new ResponseEntity<>(solicitations, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> deleteById(Integer id) {
		solicitationRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
