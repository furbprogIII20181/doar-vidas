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

import com.furb.br.doarvidas.model.entities.DonationEntity;
import com.furb.br.doarvidas.model.entities.DonatorEntity;
import com.furb.br.doarvidas.model.entities.InstitutionEntity;
import com.furb.br.doarvidas.model.pojo.DonationPojo;
import com.furb.br.doarvidas.repository.DonationRepository;
import com.furb.br.doarvidas.repository.DonatorRepository;
import com.furb.br.doarvidas.repository.InstitutionRepository;

/**
 * EndPoint for {@link DonationEntity}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/rest/private/donation")
public class DonationController {

	@Autowired
	private DonationRepository donationRepo;
	
	@Autowired
	private DonatorRepository donatorRepo;
	
	@Autowired
	private InstitutionRepository institutionRepo;
	
	@RequestMapping(method = RequestMethod.POST, value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody DonationPojo donation){
		// Busca o donator
		Optional<DonatorEntity> donator = donatorRepo.findById(donation.getDonatorID());
		// Buscar a institution
		Optional<InstitutionEntity> institution = institutionRepo.findById(donation.getInstitutionID());
		
		if (donator.isPresent() && institution.isPresent()) {
			DonationEntity savedDonation = donationRepo
					.save(new DonationEntity(donation.getDate(), donator.get(), institution.get()));
			return new ResponseEntity<>(savedDonation, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
