package com.furb.br.doarvidas.repository;

import java.util.Optional;

import com.furb.br.doarvidas.model.UserEntity;

/**
 * Repository of {@link UserEntity}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public interface UserRepository extends BasicRepository<UserEntity> {

	Optional<UserEntity> findByEmail(String email);
	
}
