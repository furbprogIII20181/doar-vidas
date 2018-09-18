package com.furb.br.doarvidas.repository;

import com.furb.br.doarvidas.model.User;

/**
 * Repositório de {@link User}
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
public interface UserRepository extends BasicRepository<User> {

	User findByUserName(String userName);
	
}
