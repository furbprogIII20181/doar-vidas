package com.furb.br.doarvidas.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.furb.br.doarvidas.model.entities.BasicEntity;

/**
 * Base repository of the application, all repositories extends from this one
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public interface BasicRepository<T extends BasicEntity> extends CrudRepository<T, Integer> {

	Optional<T> findById(Integer id);
	
}
