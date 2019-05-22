package com.furb.br.doarvidas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furb.br.doarvidas.model.entities.DonationEntity;
import com.furb.br.doarvidas.model.entities.DonatorEntity;
import com.furb.br.doarvidas.model.entities.InstitutionEntity;
import com.furb.br.doarvidas.model.pojo.DonationPojo;
import com.furb.br.doarvidas.model.pojo.DonationTablePojo;
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
public class DonationController extends AbstractController<DonationPojo> {

	@Autowired
	private DonationRepository donationRepo;

	@Autowired
	private DonatorRepository donatorRepo;

	@Autowired
	private InstitutionRepository institutionRepo;

	@Override
	public ResponseEntity<?> save(@RequestBody DonationPojo donation) {
		// Find the donator
		Optional<DonatorEntity> donator = donatorRepo.findById(donation.getDonatorID());
		// Find the institution
		Optional<InstitutionEntity> institution = institutionRepo.findById(donation.getInstitutionID());

		if (donator.isPresent() && institution.isPresent()) {
			DonationEntity savedDonation = donationRepo
					.save(new DonationEntity(donation.getDate(), donator.get(), institution.get()));
			return new ResponseEntity<>(savedDonation, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/donations/{id:[0-9][0-9]*}")
	public ResponseEntity<?> getDonationsByDonator(@PathVariable("id") Integer id) {
		List<DonationEntity> donators = donationRepo.findAllByDonatorId(id);
		List<DonationTablePojo> pojo = new ArrayList<>();
		donators.forEach(d -> {
			pojo.add(new DonationTablePojo(d.getId(), d.getInstitution().getName(), d.getInstitution().getCity(),
					d.getInstitution().getState(), d.getDate()));
		});

		return new ResponseEntity<>(pojo, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		donationRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> listAll() {
		Iterable<DonationEntity> allDonations = donationRepo.findAll();
		List<DonationEntity> donations = StreamSupport.stream(allDonations.spliterator(), false)
				.collect(Collectors.toList());
		return new ResponseEntity<>(donations, HttpStatus.OK);
	}

}
