package com.furb.br.doarvidas.repository;

import java.util.Optional;

import com.furb.br.doarvidas.model.User;
import com.furb.br.doarvidas.model.entities.DonatorEntity;

/**
 * Repository of {@link DonatorEntity} 
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public interface DonatorRepository extends BasicRepository<DonatorEntity> {

	Optional<DonatorEntity> findByUser(User user);
	
}
