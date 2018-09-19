package com.furb.br.doarvidas.repository;

import java.util.Optional;

import com.furb.br.doarvidas.model.User;

/**
 * Repositório de {@link User}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public interface UserRepository extends BasicRepository<User> {

	Optional<User> findByEmail(String email);
	
}
