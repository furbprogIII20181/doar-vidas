package com.furb.br.doarvidas.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.furb.br.doarvidas.model.entities.InstitutionEntity;
import com.furb.br.doarvidas.model.entities.SolicitationEntity;
import com.furb.br.doarvidas.model.pojo.BaixaPojo;
import com.furb.br.doarvidas.model.pojo.SolicitationDonationPojo;
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
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

	@Override
    public ResponseEntity<?> listAll(){
		Iterable<SolicitationEntity> allSolicitation = solicitationRepo.findAll();
		List<SolicitationEntity> solicitations = StreamSupport
			    .stream(allSolicitation.spliterator(), false)
			    .collect(Collectors.toList());
    	return new ResponseEntity<>(solicitations, HttpStatus.OK);
    }
	
	@GetMapping(value = "findByInstitution/{institutionId:[0-9][0-9]*}")
	public ResponseEntity<?> findByInstitution(@PathVariable("institutionId") Integer institutionId) {
		Optional<InstitutionEntity> institution = institutionRepo.findById(institutionId);
		if (institution.isPresent()) {
			Iterable<SolicitationEntity> allSolicitations = solicitationRepo.findByInstitution(institution.get());
			List<SolicitationEntity> solicitations = StreamSupport
				    .stream(allSolicitations.spliterator(), false)
				    .collect(Collectors.toList());
			return new ResponseEntity<>(solicitations, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/{id:[0-9][0-9]*}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		Optional<SolicitationEntity> solicitation = solicitationRepo.findById(id);
		if (solicitation.isPresent()) {
			// criar o pojo e retorna-lo
			SolicitationEntity solicitationEntity = solicitation.get();
			SolicitationDonationPojo solicitationPojo = new SolicitationDonationPojo();
			solicitationPojo.setId(id);
			solicitationPojo.setInstitutionId(solicitationEntity.getInstitution().getId());
			solicitationPojo.setName(solicitationEntity.getInstitution().getName());
			solicitationPojo.setLastName(solicitationEntity.getInstitution().getLastName());
			solicitationPojo.setCity(solicitationEntity.getInstitution().getCity());
			solicitationPojo.setState(solicitationEntity.getInstitution().getState());
			solicitationPojo.setDescription(solicitationEntity.getInstitution().getDescription());
			solicitationPojo.setBloodType(solicitationEntity.getBloodType());
			return new ResponseEntity<>(solicitationPojo, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "baixa", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> baixa(@RequestBody BaixaPojo pojo) {
		Optional<SolicitationEntity> solicitation = solicitationRepo.findById(pojo.getId());
		if (solicitation.isPresent()) {
			solicitation.get().setQuantity(solicitation.get().getQuantity() - pojo.getQuantity());
			return new ResponseEntity<>(solicitationRepo.save(solicitation.get()), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		solicitationRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
