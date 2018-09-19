package com.furb.br.doarvidas.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.furb.br.doarvidas.repository.UserRepository;

/**
 * This service loads the User by his username (email)
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findByEmail(username).map(u -> new org.springframework.security.core.userdetails.User(
				u.getEmail(), u.getPassword(),
				AuthorityUtils.createAuthorityList(u.getRoles().stream().map(r -> "ROLE_" + r.getName().toUpperCase())
						.collect(Collectors.toList()).toArray(new String[] {}))))
				.orElseThrow(() -> new UsernameNotFoundException(
						"No user with " + "the name " + username + "was found in the database"));
    }

}