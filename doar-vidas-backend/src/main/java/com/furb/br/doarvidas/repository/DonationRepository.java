package com.furb.br.doarvidas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.furb.br.doarvidas.model.entities.DonationEntity;

/**
 * Repository of {@link DonationEntity}  
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public interface DonationRepository extends BasicRepository<DonationEntity> {

	@Query("SELECT d FROM Donation d WHERE d.donator = :donatorId")
	List<DonationEntity> findAllByDonatorId(@Param("donatorId") Integer donatorId);
	
}
