package com.furb.br.doarvidas.repository;

import java.util.Optional;

import com.furb.br.doarvidas.model.Solicitation;
import com.furb.br.doarvidas.model.User;
import com.furb.br.doarvidas.model.entities.InstitutionEntity;
import com.furb.br.doarvidas.model.entities.SolicitationEntity;

/**
 * Repository of {@link Solicitation}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public interface SolicitationRepository extends BasicRepository<SolicitationEntity> {

	Optional<SolicitationEntity> findById(Integer id);
	
}
