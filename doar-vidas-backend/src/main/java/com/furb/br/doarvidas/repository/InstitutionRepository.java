package com.furb.br.doarvidas.repository;

import java.util.Optional;

import com.furb.br.doarvidas.model.Institution;
import com.furb.br.doarvidas.model.User;
import com.furb.br.doarvidas.model.entities.InstitutionEntity;

/**
 * Repository of {@link Institution} (Hemocentro)
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public interface InstitutionRepository extends BasicRepository<InstitutionEntity> {

	Optional<InstitutionEntity> findByUser(User user);
	
}
